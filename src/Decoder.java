import java.util.ArrayList;
import java.util.List;

public class Decoder {
    private final FrequencyTable encodedTable, sampleTable;

    public Decoder(FrequencyTable encodedTable, FrequencyTable sampleTable){
        this.encodedTable = encodedTable;
        this.sampleTable = sampleTable;
    }


    // метод Расшифровка буква за буквой

    public String decodeTextByLetter (String encodedText){
        char currentChar, newChar;
        int positionInFreqTable;
        String decodedText = "";
        for (int i = 0; i < encodedText.length(); i++) {
            currentChar = encodedText.charAt(i);
            positionInFreqTable = 0;

            if(0x0410 <= currentChar && currentChar < 0x0430){
                while (currentChar != encodedTable.getAlphabet().get(positionInFreqTable).getUpperCase()){
                    positionInFreqTable++;
                }
                newChar = sampleTable.getAlphabet().get(positionInFreqTable).getUpperCase();
            }
            else if(0x0430 <= currentChar && currentChar < 0x0450){
                while (currentChar != encodedTable.getAlphabet().get(positionInFreqTable).getLowerCase()){
                    positionInFreqTable++;
                }
                newChar = sampleTable.getAlphabet().get(positionInFreqTable).getLowerCase();
            }
            else{
                newChar = encodedText.charAt(i);
            }
            decodedText += newChar;
        }
        return decodedText;

    }

}
