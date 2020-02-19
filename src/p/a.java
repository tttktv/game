package p;

import java.util.*;

public class a {
    private Player Pl[]=new Player[1000];
    private ArrayList<Player> Liga1= new ArrayList<>();
    private ArrayList<Player> Liga2= new ArrayList<>();
    private ArrayList<Player> Liga3= new ArrayList<>();
    private static int count;
    static boolean F=true;

    public static void main(String[] args) {
        a a = new a();
        a.init();
        a.liga();
        int i=0;
        while(true) {
            Scanner in = new Scanner(System.in);
            System.out.println("1.Игра");
            System.out.println("2.Вывести всех игроков");
            System.out.println("3.Вывести игроков из одной лиги");
            System.out.println("4.Удалить игрока по нику");
            System.out.println("5.Выход");
            i = in.nextInt();

            switch (i) {
                case 1:
                    int kolDay;
                    System.out.println("Введите кол-во дней:");
                    kolDay=in.nextInt();
                    for (int j = 0; j < kolDay; j++) {
                        a.game(a.Liga1);
                        a.game(a.Liga2);
                        a.game(a.Liga3);
                        count++;
                        if (count==30){
                            a.perehod(a.Liga1,a.Liga2,a.Liga3);
                            count=0;
                        }
                    }
                    break;
                case 2:
                    a.print(a.Liga1);
                    if (F) a.print(a.Liga2);
                    if (F) a.print(a.Liga3);
                    break;
                case 3:
                    int j = 0;
                    System.out.println("Номер лиги");
                    j = in.nextInt();
                    switch (j) {
                        case 1:
                            int t=0;
                            System.out.println("Сортировать по 1)нику или 2)ммр?");
                            t = in.nextInt();
                            switch(t) {
                                case 1:
                                    a.Liga1.sort(Comparator.comparing(Player::getNickname));
                                    a.print(a.Liga1);
                                    break;
                                case 2:
                                    a.Liga1.sort(Comparator.comparing(Player::getMmr));
                                    a.print(a.Liga1);
                                    break;
                            }
                            break;
                        case 2:
                            int t1=0;
                            System.out.println("Сортировать по 1)нику или 2)ммр?");
                            t1 = in.nextInt();
                            switch(t1) {
                                case 1:
                                    a.Liga2.sort(Comparator.comparing(Player::getNickname));
                                    a.print(a.Liga2);
                                    break;
                                case 2:
                                    a.Liga2.sort(Comparator.comparing(Player::getMmr));
                                    a.print(a.Liga2);
                                    break;
                            }
                            break;
                        case 3:
                            int t2=0;
                            System.out.println("Сортировать по 1)нику или 2)ммр?");
                            t2 = in.nextInt();
                            switch(t2) {
                                case 1:
                                    a.Liga3.sort(Comparator.comparing(Player::getNickname));
                                    a.print(a.Liga3);
                                    break;
                                case 2:
                                    a.Liga3.sort(Comparator.comparing(Player::getMmr));
                                    a.print(a.Liga3);
                                    break;
                            }
                            break;
                    }
                    break;

                case 4:
                    Scanner in2=new Scanner(System.in);
                    Scanner in3=new Scanner(System.in);
                    int lig;
                    String name;
                    System.out.println("Из какой лиги удаляем?");
                    lig=in2.nextInt();
                    System.out.println("Введите имя:");
                    name=in3.nextLine();
                    switch(lig) {
                        case 1:
                            if (a.Liga1.removeIf(it -> it.getNickname().equals(name))) System.out.println("Ok");
                            break;
                        case 2:
                            if (a.Liga2.removeIf(it -> it.getNickname().equals(name))) System.out.println("Ok");
                            break;
                        case 3:
                            if (a.Liga3.removeIf(it -> it.getNickname().equals(name))) System.out.println("Ok");
                            break;
                    }
                    break;
                case 5:
                    return;
            }
        }
    }

    public void perehod(ArrayList<Player> liga1,ArrayList<Player> liga2,ArrayList<Player> liga3){
        //int razm=liga3.size()/10*9;
        ArrayList<Player> k3=new ArrayList<>();
        ArrayList<Player> o3=new ArrayList<>();
        ArrayList<Player> n2=new ArrayList<>();
        ArrayList<Player> s2=new ArrayList<>();
        ArrayList<Player> k2=new ArrayList<>();
        ArrayList<Player> n1=new ArrayList<>();
        ArrayList<Player> s1=new ArrayList<>();
        ArrayList<Player> k1=new ArrayList<>();
        k3.addAll(liga3.subList(liga3.size()*9/10,liga3.size()));//конец 3 лиги
        o3.addAll(liga3.subList(liga3.size()*9/10,liga3.size()));//основная часть 3 лиги
        n2.addAll(liga2.subList(0,liga2.size()/10));//начало 2 лиги
        s2.addAll(liga2.subList(liga2.size()/10,liga2.size()*9/10));//середина 2 лиги
        k2.addAll(liga2.subList(liga2.size()*9/10,liga2.size()));//конец 2 лиги
        n1.addAll(liga1.subList(0,liga1.size()/10));//начало 1 лиги
        s1.addAll(liga1.subList(liga1.size()/10,liga1.size()*9/10));//середина 2 лиги
        k1.addAll(liga1.subList(liga1.size()*9/10,liga1.size()));//конец 1 лиги
        liga3.clear();
        liga3.addAll(o3);
        liga3.addAll(n2);
        liga2.clear();
        liga2.addAll(k3);
        liga2.addAll(s2);
        liga2.addAll(n1);
        liga1.clear();
        liga1.addAll(k2);
        liga1.addAll(s1);
        liga1.addAll(k1);

    }


    public void liga(){
        for (int i=0;i<Pl.length;i++) {
            if (Pl[i].getMmr()<300){
                Liga1.add(Pl[i]);
            }
            if (Pl[i].getMmr()<600 && Pl[i].getMmr()>300){
                Liga2.add(Pl[i]);
            }
            if (Pl[i].getMmr()<900 && Pl[i].getMmr()>600){
                Liga3.add(Pl[i]);
            }
        }
       // System.out.println(Liga1.toString()+"\n"+Liga2.toString()+"\n"+Liga3.toString());
    }

    public void init(){
        String dict = "abcdefghijklmnopqrstuvwxyz";
        for (int i=0;i<Pl.length;i++){
            Random rand = new Random();
            String name;
            name=generateString(dict);
            Pl[i]=new Player(name, rand.nextInt(900));
           // System.out.println(Pl[i].getNickname()+"  "+Pl[i].getMmr());
        }
    }


    public String generateString(String characters)
    {
        Random rand = new Random();
        char[] text = new char[rand.nextInt(10)+3];
        for (int i = 0; i < text.length; i++)
        {
            text[i] = characters.charAt(rand.nextInt(characters.length()));
        }
        return new String(text);
    }

    public void game(ArrayList<Player> liga){
        Random rand = new Random();
        Player Commanda1[] = new Player[5];
        Player Commanda2[] = new Player[5];

        liga.trimToSize();
        liga.sort(Comparator.comparing(Player::getMmr));

        for(int i = 0; i < liga.size();i+=10){
            if (liga.size()-i<10){
                break;
            }
            Commanda1[0] = (liga.get(i));
            Commanda1[1] = (liga.get(i+1));
            Commanda1[2] = (liga.get(i+2));
            Commanda1[3] = (liga.get(i+3));
            Commanda1[4] = (liga.get(i+4));

            Commanda2[0] = (liga.get(i+5));
            Commanda2[1] = (liga.get(i+6));
            Commanda2[2] = (liga.get(i+7));
            Commanda2[3] = (liga.get(i+8));
            Commanda2[4] = (liga.get(i+9));

            int rez1,rez2;
            rez1=Commanda1[0].getMmr()+Commanda1[1].getMmr()+Commanda1[2].getMmr()+Commanda1[3].getMmr()+Commanda1[4].getMmr();
            rez2=Commanda2[0].getMmr()+Commanda2[1].getMmr()+Commanda2[2].getMmr()+Commanda2[3].getMmr()+Commanda2[4].getMmr();
            if (rez1>rez2){
                for (int j=0;j<5;j++){
                    Commanda1[j].addMmr(rand.nextInt(15)+5);
                    Commanda2[j].addMmr(-(rand.nextInt(15)+5));
                    if (Commanda2[j].getMmr()<0){
                        Commanda2[j].setMmr(0);
                    }
                    Commanda1[j].win(true);
                    Commanda2[j].win(false);
                }

            }
            if (rez2>rez1){
                for (int j=0;j<5;j++){
                    Commanda2[j].addMmr(rand.nextInt(15)+5);
                    Commanda1[j].addMmr(-(rand.nextInt(15)+5));
                    if (Commanda1[j].getMmr()<0){
                        Commanda1[j].setMmr(0);
                    }
                    Commanda1[j].win(false);
                    Commanda2[j].win(true);
                }

            }
        }


    }

    public void print(ArrayList<Player> liga) {
        int count = 0;
        String next;
        Scanner in = new Scanner(System.in);
        for (Player p : liga) {
            System.out.println(p);
            count++;
            if (count == 10) {
                next=in.nextLine();
                if (next.equals("далее")){
                    count = 0;
                }
                if (next.equals("выход")){
                    F=false;
                    return;
                }
                if (!(next.equals("далее"))&&!(next.equals("выход"))){
                    System.out.println("Неправильно");
                    next=in.nextLine();
                    count = 0;
                    if (next.equals("выход")){
                        F=false;
                        return;
                    }
                }
                //count = 0;
            }
        }
    }
}
