public class RegisterExeption extends Throwable {

    RegisterExeption(){
        System.err.println("Пароли не совпадают");
    }

}
