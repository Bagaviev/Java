package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Ошибка при отправке сообщения.");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String username = null;

            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message response = connection.receive();

                if (response.getType() == MessageType.USER_NAME && response.getData() != null && response.getData() != "")
                    username = response.getData();
                else
                    continue;

                if (connectionMap.containsKey(username))
                    continue;
                else
                    connectionMap.put(username, connection);

                connection.send(new Message(MessageType.NAME_ACCEPTED));
                return username;
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> pair: connectionMap.entrySet()) {
                if (!pair.getKey().equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, pair.getKey()));
            }
        }

        private void serverMainLoop(Connection connection, String userName) {
            while (true) {
                Message request = null;


                // новодел, чтобы не было exception после дисконнекта клиента
                try {request = connection.receive();}
                catch (Exception e) {}

                if (request == null)
                    return;
                //
                if (request.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + request.getData()));
                } else
                    ConsoleHelper.writeMessage("Ошибка содержимого сообщения: не текст");
            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено новое соединение с " + socket.getRemoteSocketAddress());
            String newUsername = null;

            try (Connection conn = new Connection(socket)) {

                newUsername = serverHandshake(conn);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, newUsername));

                notifyUsers(conn, newUsername);
                serverMainLoop(conn, newUsername);

            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
                e.printStackTrace();
            }

            if (newUsername != null) {
                connectionMap.remove(newUsername);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newUsername));
            }
            ConsoleHelper.writeMessage("Соединение с " + socket.getRemoteSocketAddress() + " закрыто.");
        }
    }



    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        int port = ConsoleHelper.readInt();
        Socket newSocket = null;

        try(ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Чат сервер запущен!");
            while (true) {
                newSocket = serverSocket.accept();
                new Handler(newSocket).start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Произошла ошибка при запуске или работе сервера." + "\\n" + e.getMessage());
        }
    }
}