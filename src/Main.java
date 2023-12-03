public class Main {
    public static void main(String[] args) {
        User admin = new User("admin", "admin", 0, true);
        User mahasiswa = new User("123456789", "UEU2023", 1, true);

        admin.login();
        mahasiswa.login();
    }

}