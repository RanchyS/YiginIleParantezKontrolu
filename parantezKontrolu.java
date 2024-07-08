class Yigin {

    char[] dizi;
    int boyut;
    int top;

    public Yigin(char[] dizi) {
        this.dizi = dizi;
        this.boyut = dizi.length;
        this.top = dizi.length - 1;
    }

    public Yigin(int boyut) {
        dizi = new char[boyut];
        this.boyut = boyut;
        top = -1;
    }

    public boolean bosMu() {
        return top == -1;
    }

    public boolean doluMu() {
        return top == boyut - 1;
    }

    public void push(char karakter) {
        if (doluMu()) {
            System.out.println("Yigin dolu oldugundan ekleme islemi yapilamadi!");
        } else {
            top++;
            dizi[top] = karakter;
        }
    }

    public char pop() {
        if (bosMu()) {
            System.out.println("Yigin bos oldugundan silme islemi yapilamadi!");
        } else {
            top--;
        }

        return dizi[top + 1];
    }

    public void listele() {
        if (bosMu()) {
            System.out.println("Yigin bos oldugundan listeleme islemi gerceklestirilemedi!");
        } else {
            for (int i = 0; i <= top; i++) {
                System.out.println(dizi[i]);
            }
        }
    }

}

public class parantezKontrolu {

    public static void parantezKontrol(char[] dizi) {
        Yigin yigin = new Yigin(dizi.length);  //"(2+3)*{[(3+4)+(4+5)]*[(5+6)+(6+7)]}"

        boolean dogruMu = true;
        char popped;

        for (int i = 0; i < dizi.length; i++) {

            if (dizi[i] == '(' || dizi[i] == '[' || dizi[i] == '{') {
                yigin.push(dizi[i]);
            }

            if (dizi[i] == ')') {
                popped = yigin.pop();
                if ('(' != popped) {
                    dogruMu = false;
                    break;
                }
            }

            if (dizi[i] == ']') {
                if ('[' != yigin.pop()) {
                    dogruMu = false;
                    break;
                }
            }

            if (dizi[i] == '}') {
                if ('{' != yigin.pop()) {
                    dogruMu = false;
                    break;
                }
            }
        }

        if (dogruMu) {
            System.out.println("dogrudur");
        } else {
            System.out.println("yanlistir");
        }

    }

    public static void main(String[] args) {
        String str = "((2+3)*{[(3+4)+(4+5)]*[(5+6)+(6+7)]}"; //19
        char[] dizi = str.toCharArray();

        parantezKontrol(dizi);

    }
}