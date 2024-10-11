public class Main {
    public static void main(String[] args) {
        Client c1 = new Client("Nicolas", "nicolas@gmail.com");
        Client c2 = new Client("Maria", "maria@gmail.com");

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c1.equals(c2));
        System.out.println(c1 == c2);

        String s1 = new String("Test");
        String s2 = new String("Test");

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2); //Avalia a referencia na memoria, nao o conteudo

    }
}