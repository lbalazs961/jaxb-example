package legoset;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Year;
import java.util.*;

import jaxb.JAXBHelper;

import javax.xml.bind.JAXBException;

public class Main {
    public static void main(String[] args) throws MalformedURLException, JAXBException, FileNotFoundException {
        LegoSet legoSet = new LegoSet();
        legoSet.setNumber("75211");
        legoSet.setName("Imperial TIE Fighter");
        legoSet.setTheme("Star Wars");
        legoSet.setSubtheme("Solo");
        legoSet.setYear(Year.of(2018));
        legoSet.setPieces(519);

        Set<String> tags = new LinkedHashSet<String>();
        tags.add("Starfighter");
        tags.add("Stormtrooper");
        tags.add("Star Wars");
        tags.add("Solo");

        legoSet.setTags(tags);

        List<MiniFig> minifigs = new ArrayList<MiniFig>();
        minifigs.add(new MiniFig("Imperial Mudtrooper", 2));
        minifigs.add(new MiniFig("Imperial Pilot", 1));
        minifigs.add(new MiniFig("Mimban Stormtrooper", 1));

        legoSet.setMinifigs(minifigs);
        legoSet.setWeight(new Weight(0.89, "kg"));
        legoSet.setUrl(new URL("https://brickset.com/sets/75211-1/Imperial-TIE-Fighter"));

        JAXBHelper.toXML(legoSet, System.out);

        JAXBHelper.toXML(legoSet, new FileOutputStream("legoset.xml"));
        System.out.println(JAXBHelper.fromXML(LegoSet.class, new FileInputStream("legoset.xml")));

    }
}
