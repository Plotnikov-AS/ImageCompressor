import java.io.File;

public class Main {
    private static int threadNumbers = Runtime.getRuntime().availableProcessors();
    private static int newWidth = 300;

    public static void main(String[] args) {
        String srcFolder = "D:\\SkillBox Java\\Модуль 11\\images";
        String dstFolder = "D:\\SkillBox Java\\Модуль 11\\compressedImages";

        File scrDir = new File(srcFolder);

        File[] files = scrDir.listFiles();

        int arrayPartSize = files.length / threadNumbers;
        int startIndex = 0;
        for (int i = 0; i < threadNumbers; i++){
            File[] filesArrayPart = new File[arrayPartSize];
            System.arraycopy(files, startIndex, filesArrayPart,0, arrayPartSize);
            ImageResizer resizer = new ImageResizer(filesArrayPart, newWidth, dstFolder);
            new Thread(resizer).start();
            startIndex += arrayPartSize;
        }
    }
}
