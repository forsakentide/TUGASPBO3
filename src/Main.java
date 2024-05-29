import java.lang.*;

abstract class Individu
{
    protected String nama;
    protected String jurusan;
    protected int umur;

    public Individu(String nama, String jurusan, int umur)
    {
        this.nama = nama;
        this.jurusan = jurusan;
        this.umur = umur;
    }

    public abstract void introduce();

    public void printMessage()
    {
        System.out.println("Message from base class.");
    }
}

class Student extends Individu
{
    private int angkatan;

    public Student(String nama, String jurusan, int umur, int angkatan)
    {
        super(nama, jurusan, umur);
        this.angkatan = angkatan;
    }

    @Override
    public void introduce()
    {
        System.out.println("Saya adalah mahasiswi Universitas Esa Unggul yang bernama " + nama + ", saya berumur " + umur + " tahun, saya dari fakultas Ilmu Komputer jurusan " + jurusan + ", angkatan " + angkatan);
    }

    @Override
    public void printMessage()
    {
        System.out.println("Message from student class.");
    }
}

class Introduction extends Individu
{
    private String posisi;
    private String sks;

    public Introduction(String nama, String posisi, String sks)
    {
        super(nama, "", 0); // values default dari jurusan sama umur
        this.posisi = posisi;
        this.sks = sks;
    }

    @Override
    public void introduce()
    {
        System.out.println("Saya, yang bernama " + nama + " saat ini sedang bekerja diposisi " + posisi + " mengambil program kelas karyawan di Universitas Esa Unggul, tahun ini saya menduduki semester 3 dengan total " + sks + " sks.");
    }

    // ini garbage collector
    @Override
    protected void finalize() throws Throwable
    {
        System.out.println("Object for " + nama + " is being garbage collected!");
        super.finalize();
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Student student = new Student("Defira Patricia", "Teknik Informatika", 23, 2022);
        student.introduce();
        student.printMessage(); // ini polymorphism

        Introduction introduction = new Introduction("Defira", "Admin", "21");
        introduction.introduce();
        introduction.printMessage();

        introduction = null;
        System.gc();
    }
}
