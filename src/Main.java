import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    static StringBuilder builder = new StringBuilder();
    static List<String> step1 = new ArrayList<>();
    static List<String> step2 = new ArrayList<>();
    static List<String> step4 = new ArrayList<>();

    public static void main(String[] args) {
        builder.append("Начало работы.\n");
        step1.add("/home/jackxammer/Documents/Games/src");
        step1.add("/home/jackxammer/Documents/Games/res");
        step1.add("/home/jackxammer/Documents/Games/savegames");
        step1.add("/home/jackxammer/Documents/Games/temp");

        step2.add("/home/jackxammer/Documents/Games/src/main");
        step2.add("/home/jackxammer/Documents/Games/src/test");

        step4.add("/home/jackxammer/Documents/Games/res/drawables");
        step4.add("/home/jackxammer/Documents/Games/res/vectors");
        step4.add("/home/jackxammer/Documents/Games/res/icons");

        dirStepExecutor(step1);
        dirStepExecutor(step2);
        fileCreator("/home/jackxammer/Documents/Games/src/main", "Main.java");
        fileCreator("/home/jackxammer/Documents/Games/src/main", "Utils.java");
        dirStepExecutor(step4);
        fileCreator("/home/jackxammer/Documents/Games/temp", "temp.txt");

        //System.out.println(builder.toString());
        String log = builder.toString();

        try (FileWriter writer = new FileWriter("/home/jackxammer/Documents/Games/temp/temp.txt", false)) {
            writer.write(log);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void dirCreator(String path) {
        File dir = new File(path);
        if (dir.mkdir())
            builder.append("Создан каталог " + path + "\n");
    }

    public static void dirStepExecutor(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            dirCreator(iterator.next());
        }
    }

    public static void fileCreator(String path, String name) {
        File file = new File(path, name);
        try {
            boolean created = file.createNewFile();
            if (created)
                builder.append("В каталоге " + path + " создан файл " + name + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}