import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SmashDeck {
    private File inFile;
    private ArrayList<Smashcard> deck = new ArrayList<>();
    private String file = "";
    private static final String SC_SPACER = "\nspace\n";
    private static final String SC_END = "\nend\n";

    public void add(String tech, Integer reps)
    {
        if(tech.length() == 0)
            tech = "";
        if(reps < 0)
            reps = 0;
        Smashcard sc = new Smashcard(tech, reps);
        deck.add(sc);
    }
    //todo need some parser
    private void parser(String notParsed)
    {
        String[] splitFromFile = notParsed.split(SC_END);
        for(String splitEach : splitFromFile)
        {
            String[] data = splitEach.split(SC_SPACER);
            add(data[0], Integer.valueOf(data[1]));
        }
    }

    //todo need some file reader

    private void fileReader(String loc)
    {
        inFile = new File(loc);
        setFile(inFile.getName());
        assert inFile.canRead();
        try(BufferedReader reader = new BufferedReader(new FileReader(inFile)))
        {
            int val;
            StringBuilder data = new StringBuilder();
            while((val=reader.read()) != -1)
            {
                data.append((char) val);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //todo need some file saver
    public void fileSaver(String loc)
    {
        inFile = new File(loc);
        assert inFile.canWrite();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inFile)))
        {
            for(Smashcard sc : deck)
            {
                writer.write(sc.getTech() + SC_SPACER + sc.getReps() + SC_END);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    public String getFile()
    {
        return inFile.getAbsolutePath();
    }
    public ArrayList<Smashcard> getDeck()
    {
        return deck;
    }
    public String getFileName()
    {
        return file;
    }

    public void setDeck(ArrayList<Smashcard> deck) {
        this.deck = deck;
    }
    public void setInFile(File f)
    {
        inFile = f;
    }
    public void setFile(String file) {
        this.file = file;
    }
}
