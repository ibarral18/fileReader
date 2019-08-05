import java.io.*;
import java.util.*;
class Reader {
  public ArrayList<String> apiSheet =  new ArrayList<>();
  public Reader(String dic){
        try{
            File apiFile = new File(dic);
            Scanner s = new Scanner(apiFile);
            int x = 1;
            int z = 1;
            for(int y = 1; s.hasNextLine(); y++){
              if(y == ((2*x)-1)){
                s.nextLine();
                x++;
              }
/*
              else if(y == 2*z){
                s.nextLine();
                z++;
              }
  */            else{
                String dicWord = s.nextLine();
      
                apiSheet.add(dicWord);
              }
            }
            String out = "new";
            createFile("new", apiSheet);
        }
        
        catch(Exception e){
            System.out.println("File not found ! ");
        }
        System.out.println(apiSheet);
    }
    private void createFile(String file, ArrayList<String> arrData) throws IOException  {
        FileWriter writer = new FileWriter(file + ".txt");
        int size = arrData.size();
        for (int i=0;i<size;i++) {
            String str = arrData.get(i).toString();
            writer.write(str);
            if(i < size-1)
                writer.write("\n");
        }
        writer.close();
    }

}