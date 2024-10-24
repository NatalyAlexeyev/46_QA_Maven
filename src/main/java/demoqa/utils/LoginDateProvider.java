package demoqa.utils;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDateProvider {
//    @DataProvider(name = "loginData")
//    public Object[][] getLoginData() {
//        return new Object[][]{
//                {"Sofya", "!Milka_04"}
//        };
//    }
//}
//@DataProvider(name = "loginData")
//public Object[][] getLoginData() {
//    return new Object[][]{
//            {"Sofya", "!Milka_04"}, // Верные данные, ожидается успешный вход
//            {"Sofya", "!Milka_04123"}, // Неверный пароль, ожидается ошибка
//            {"Sofya123", "!Milka_04"}, // Неверное имя пользователя, ожидается ошибка
//            {"Sofya", "!Milka_04"}// Верные данные, ожидается успешный вход
//    };
//}

    @DataProvider(name = "loginData")
    public Iterator<Object[]> getLoginData() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/login.csv"));
        String line = reader.readLine();
        while (line != null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }
}