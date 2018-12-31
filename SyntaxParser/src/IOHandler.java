import java.io.*;
import java.util.Iterator;
import java.util.List;

public class IOHandler {

    public IOHandler(){

    }

    public String readFile(){
        String inputFile = "input.txt";
        String re="";
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(new File(inputFile))));

            String line;
           while((line = bf.readLine()) != null) {
                re+=line;
            }

            re += '$';
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return re;
    }

    public void writeFile(List<String> output){
        File outputFile = new File("output.txt");
        try {
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));

            StringBuffer buf=new StringBuffer();
            for (String s:output) {
                buf.append(s);
                buf.append(System.lineSeparator());
            }

            bw.write(buf.toString());
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
