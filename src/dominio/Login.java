/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author martin.trindade
 */
public class Login {
    private String mail;
    private String pass;

  

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    

    public String getMail() {
        return mail;
    }

    public String getPass() {
        return pass;
    }

    public Login(String mail, String pass) {
        this.mail = mail;
        this.pass = pass;
    }
        
    public boolean validarUsuario(String usuario, String pass){
        if(usuario.equals("admin") && pass.equals("admin")) {
            return true;
        }
        else{
            return false;
        }
    }    
}
