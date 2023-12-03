import java.util.Scanner;

public class User {
    private String namaUser ;
    private String passwordUser ;
    private int roleUser;
    private boolean statusUser ;

    public User(String namaUser, String passwordUser, int roleUser, boolean statusUser) {
        this.namaUser = namaUser;
        this.passwordUser = passwordUser;
        this.roleUser = roleUser;
        this.statusUser = statusUser;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public int getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(int roleUser) {
        this.roleUser = roleUser;
    }

    public boolean isStatusUser() {
        return statusUser;
    }

    public void setStatusUser(boolean statusUser) {
        this.statusUser = statusUser;
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Username: ");
        String inputNamaUser = scanner.nextLine();

        System.out.print("Masukkan Password: ");
        String inputPassword = scanner.nextLine();

        if (inputNamaUser.equals("admin") && inputPassword.equals("admin")) {
            roleUser = 0;
            System.out.println("Login berhasil sebagai admin.");
            dashboard();
        } else if (inputPassword.equals("UEU2023")) {
            roleUser = 1;
            System.out.println("Login berhasil sebagai mahasiswa.");
            dashboard();
        } else {
            System.out.println("Login gagal. Periksa kembali nama user dan password.");
        }
    }

    public void dashboard() {
        if (roleUser == 0) {

            System.out.println("Sistem Akademik UEU | Admin");
            System.out.println("1. Update Status Mahasiswa");
            System.out.println("2. Update Password Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");

            Scanner scanner = new Scanner(System.in);
            int pilih = scanner.nextInt();

            switch (pilih) {
                case 1:
                    updateStatus();
                    break;
                case 2:
                    updatePassword();
                    break;
                case 0:
                    System.out.println("Logout berhasil.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } else if (roleUser == 1) {

            System.out.println("Sistem Akademik UEU | Mahasiswa");
            System.out.println("1. Update Password");
            System.out.println("0. logout");
            System.out.print("Pilih menu: ");

            Scanner scanner = new Scanner(System.in);
            int pilih = scanner.nextInt();

            switch (pilih) {
                case 1:
                    updatePassword();
                    break;
                case 0:
                    System.out.println("Logout berhasil.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }

    public void updateStatus() {
        if (roleUser == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Masukkan Username mahasiswa yang akan diupdate statusnya: ");
            String namaMahasiswa = scanner.nextLine();
            System.out.println("\nGanti Status Mahasiswa:");
            System.out.println("1. Aktif");
            System.out.println("2. Tidak Aktif");
            System.out.print("Pilih menu: ");

            int newStatus = scanner.nextInt();
            switch (newStatus) {
                case 1:
                    statusUser = true;
                    System.out.println("Status Mahasiswa berhasil diubah menjadi Aktif.");
                    break;
                case 2:
                    statusUser = false;
                    System.out.println("Status Mahasiswa berhasil diubah menjadi Tidak Aktif.");
                    break;
                default:
                    System.out.println("Pilihan status tidak valid.");
            }

            System.out.println("Status Username Mahasiswa " + namaMahasiswa + " berhasil diupdate menjadi " + statusUser);
        } else {
            System.out.println("Invalid");
        }
    }

    public void updatePassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan password baru: ");
        String newPassword = scanner.nextLine();
        setPasswordUser(newPassword);
        System.out.println("Password berhasil di update menjadi " + newPassword);
    }


    public void displayUserInfo() {
        System.out.println("Informasi User:");
        System.out.println("Username: " + getNamaUser());
        System.out.println("Role User: " + getRoleUser());
        System.out.println("Status User: " + isStatusUser());
    }

}