public class Cliente {

    private int id;
    private String nombre;
    private String email;
    private double saldo;

    public Cliente() {}

    public Cliente(int id, String nombre, String email, double saldo) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.saldo = saldo;
    }

    //getter
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public double getSaldo() {
        return saldo;
    }

    //setter
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    //metodo esctitura
    public String writeLine() {
        return id +";" + nombre + ";"  +email+ ";" + saldo;

    }
    //toString override
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
