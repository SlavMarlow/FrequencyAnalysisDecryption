import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Main {
    public static void main(String[] args) throws IOException {

        // шифрация примерной главы со сдвигом 2
        Path pathChapter = Paths.get("C:\\Users\\Slava\\IdeaProjects\\FrequencyAnalysisDecryption-master\\chapter.txt") ;
        String chapter = Files.readString(pathChapter);
        Encoder encoder = new Encoder(chapter, 2);
        String encodedText = encoder.getEncodedText();

        // создем таблицу частот для зашифрованной главы
        FrequencyTable tableForEncodedText = new FrequencyTable(encodedText);
        tableForEncodedText.printFrequencyTable();

        // считываем текст (война и мир)
        Path pathVIM = Paths.get("C:\\Users\\Slava\\IdeaProjects\\FrequencyAnalysisDecryption-master\\vim.txt") ;
        String sampleText = Files.readString(pathVIM);

        // для текста (война и мир) создаем таблицу частот
        FrequencyTable tableForSample = new FrequencyTable(sampleText);
        System.out.println("------------------------------------------------------------------------");
        tableForSample.printFrequencyTable();

        // побуквенная дешифрация
        Decoder decoder = new Decoder(tableForEncodedText, tableForSample);
        String decodedTextByLetter = decoder.decodeTextByLetter(encodedText);       //Decoding by letter
        System.out.println(decodedTextByLetter);


    }

}
