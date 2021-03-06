package com.mypackage;

public class Main {

    public static void main(String[] args) {
        String message[];
        String numberSet[] = {"",
                "89001112233",
                "+790011122333",
                "890011122331",
                "8 900 111 22 33",
                "8(900)1112233",
                "8(900)1112233",
                "8(900) 111 22 33 2",
                "+7 900 333 (22 11)",
                "+7 900 (22 11)",
                null
        };
        for (int i = 0; i < numberSet.length; i++) {
            message = isValidPN(numberSet[i]);

            System.out.println(message[0] + "\n    " + message[1]);
        }

    }

    private static String[] isValidPN(String number) {
        String resultMessage[] = new String[] {"",""};

        if (number == null) return resultMessage;

        if (number.contains("+7")) {
            number = number.replace("+7","8");
            resultMessage[1] += "Заменено +7 на 8; ";
        }

        if (number.contains(" ")) {
            number = number.replace(" ", "");
            resultMessage[1] += "В номере есть пробелы; ";
        }

        if (number.contains("(") || number.contains(")")) {
            number = number.replace("(","");
            number = number.replace(")","");
            resultMessage[1] += "В номере есть скобки; ";
        }

        resultMessage[0] = number;

        if (number.length() != 11) {
            resultMessage[1] += "Количество символов не равно 11; ";
            resultMessage[0] = "Введён некорректный номер";
        }
        if (resultMessage[1].isEmpty()) {
            resultMessage[1] += "Изменений не было";
        }
        return resultMessage;
    }
}
