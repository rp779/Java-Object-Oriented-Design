package JavaObjectModelExample;

import java.io.*;

public class PairTest {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {

        Pair<String, Integer> p1 = new Pair<>("key1",1);
        Pair<String, Integer> p2 = new Pair<>("key2",2);

        /* - equality with equals()*/
        System.out.println("equals " + p1.equals(p2));

        /*- cloning : make a clone and compare with the original*/
        Pair<String, Integer> p3 = null;
        try {
            p3 = (Pair<String, Integer>) p1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("Cloning " + p1.equals(p3)
                + "\t " + p1.hashCode() + "\t" + p3.hashCode());

        /* serialization. Serialize to an ObjectStream backed by a file
         and then load the object back to memory and compare it to the original with equals(). */
        String filename = "Pair_Serialize.dat";

        try {
            // Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(p1);

            out.close();
            file.close();

            System.out.println("Object has been serialized\n"
                        + "Data before Deserialization." + p1.k() + "\t" + p1.v());
            }

            catch (IOException ex) {
                System.out.println("IOException is caught");
            }

            p1 = null;
            // Deserialization
            try {

                FileInputStream file = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(file);

                // Method for deserialization of object
                p1 = (Pair<String, Integer>) in.readObject();

                in.close();
                file.close();
                System.out.println("Object has been deserialized\n"
                        + "Data after Deserialization." + p1.k() + "\t" + p1.v());

                // System.out.println("z = " + object1.z);
            }

            catch (IOException ex) {
                System.out.println("IOException is caught");
            }

            catch (ClassNotFoundException ex) {
                System.out.println("ClassNotFoundException is caught");
            }


            /*- hashCode(). Must be compatible with equals
            (i.e. equal hashCode() for equal objects, and different values
            (with high probability) for different key or/and value objects*/
            System.out.println("PairTest.main"+p1.hashCode()+"\t"+p2.hashCode());
        }
    }

