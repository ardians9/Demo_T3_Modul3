package T2;

import java.util.Scanner;


/**
 *
 */
class Employee {

    /**
     * Bonus untuk karyawan tetap dalam persentase.
     */
    public static final double Bonus = 0.10;

    /**
     * Jam kerja standar dalam seminggu.
     */
    public static final int Jam_Kerja = 40;

    /**
     * Tarif lembur dalam persentase tambahan dari tarif per jam.
     */
    public static final double Lembur = 0.5;

    private String name;
    private int hoursWorked;
    private double hourlyRate;
    private boolean isPermanent;

    /**
     * Konstruktor Employee untuk menginisialisasi data karyawan.
     *
     * @param name        Nama karyawan.
     * @param hoursWorked Jumlah jam kerja yang dilakukan oleh karyawan.
     * @param hourlyRate  Tarif per jam yang dibayar kepada karyawan.
     * @param isPermanent Status permanen atau tidaknya karyawan.
     */
    public Employee(String name, int hoursWorked, double hourlyRate, boolean isPermanent) {
        this.setName(name);
        this.setHoursWorked(hoursWorked);
        this.setHourlyRate(hourlyRate);
        this.setPermanent(isPermanent);
    }

    /**
     * Menghitung gaji total berdasarkan jam kerja, tarif per jam,
     * status permanen, dan pembayaran lembur.
     *
     * @return Total gaji karyawan.
     */
    public double calculateSalary() {
        double salary = getHoursWorked() * getHourlyRate();

        // Jika karyawan tetap, mereka mendapat bonus 10% dari total gaji
        salary = calculateBonus(salary);

        // Jika karyawan bekerja lebih dari 40 jam, ada pembayaran overtime (1.5 kali)
        if (getHoursWorked() > Jam_Kerja) {
            salary += (getHoursWorked() - Jam_Kerja) * (getHourlyRate() * Lembur); // Overtime rate 50% tambahan
        }

        return salary;
    }

    /**
     * Menghitung bonus 10% jika karyawan merupakan karyawan tetap.
     *
     * @param salary Gaji yang dihitung sebelum ditambahkan bonus.
     * @return Gaji yang sudah ditambahkan bonus (jika karyawan tetap).
     */
    private double calculateBonus(double salary) {
        if (isPermanent()) {
            salary += salary * Bonus; // Bonus 10%
        }
        return salary;
    }

    /**
     * Menampilkan informasi gaji karyawan ke layar.
     */
    public void displaySalary() {
        System.out.println("Employee Name: " + getName());
        System.out.println("Hours Worked: " + getHoursWorked());
        System.out.println("Hourly Rate: Rp." + getHourlyRate());
        System.out.println("Permanent Employee: " + (isPermanent() ? "Yes" : "No"));
        System.out.println("Total Salary: Rp." + calculateSalary());
    }

    /**
     * Mendapatkan nama karyawan.
     *
     * @return Nama karyawan.
     */
    public String getName() {
        return name;
    }

    /**
     * Menetapkan nama karyawan.
     *
     * @param name Nama karyawan.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Mendapatkan jumlah jam kerja yang dilakukan karyawan.
     *
     * @return Jumlah jam kerja.
     */
    public int getHoursWorked() {
        return hoursWorked;
    }

    /**
     * Menetapkan jumlah jam kerja yang dilakukan karyawan.
     *
     * @param hoursWorked Jumlah jam kerja.
     */
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    /**
     * Mendapatkan tarif per jam yang dibayar kepada karyawan.
     *
     * @return Tarif per jam.
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Menetapkan tarif per jam yang dibayar kepada karyawan.
     *
     * @param hourlyRate Tarif per jam.
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * Memeriksa apakah karyawan adalah karyawan tetap.
     *
     * @return True jika karyawan tetap, false jika tidak.
     */
    public boolean isPermanent() {
        return isPermanent;
    }

    /**
     * Menetapkan status permanen atau tidaknya karyawan.
     *
     * @param permanent True jika karyawan tetap, false jika tidak.
     */
    public void setPermanent(boolean permanent) {
        isPermanent = permanent;
    }
}

/**
 * Kelas salaryCalculating adalah kelas utama untuk menjalankan program kalkulasi gaji karyawan.
 * Program ini memungkinkan pengguna untuk memasukkan data karyawan dan menghitung gaji mereka.
 */
public class T2 {

    /**
     * Metode utama untuk menjalankan program kalkulasi gaji.
     *
     * @param args Argumen baris perintah (tidak digunakan dalam aplikasi ini).
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Memasukkan data karyawan
        System.out.print("Enter employee name: ");
        String name = input.nextLine();

        System.out.print("Enter hours worked: ");
        int hoursWorked = input.nextInt();

        System.out.print("Enter hourly rate: ");
        double hourlyRate = input.nextDouble();

        System.out.print("Is the employee permanent? (true/false): ");
        boolean isPermanent = input.nextBoolean();

        // Membuat objek Employee dan menghitung gaji
        Employee employee = new Employee(name, hoursWorked, hourlyRate, isPermanent);
        employee.displaySalary();

        input.close();
    }
}