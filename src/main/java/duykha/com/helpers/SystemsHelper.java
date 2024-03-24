package duykha.com.helpers;


import java.io.File;

public class SystemsHelper {

    //Hàm lấy đường dẫn tuyệt đối của project
    public static String getCurrentDir() {
        String current = System.getProperty("user.dir") + File.separator;
        return current;
    }
}
