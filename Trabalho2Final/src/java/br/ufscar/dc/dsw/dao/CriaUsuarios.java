package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Papel;
import br.ufscar.dc.dsw.pojo.Site;
import br.ufscar.dc.dsw.pojo.Teatro;
import br.ufscar.dc.dsw.pojo.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriaUsuarios {

    public static void main(String[] args) throws ClassNotFoundException {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        PapelDAO papelDAO = new PapelDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        SiteDAO siteDAO = new SiteDAO();
        TeatroDAO teatroDAO = new TeatroDAO();
        

        // Criando Usuario admin com papel ROLE_ADMIN
     
        Usuario u1 = new Usuario();
        u1.setEmail("admin@admin");
        u1.setSenha(encoder.encode("admin"));
        u1.setAtivo(true);
        usuarioDAO.save(u1);

        Papel p1 = new Papel();
        p1.setNome("ROLE_ADMIN");
        papelDAO.save(p1);
        
        Papel p2 = new Papel();
        p2.setNome("ROLE_SITE");
        papelDAO.save(p2);

        Papel p3 = new Papel();
        p3.setNome("ROLE_TEATRO");
        papelDAO.save(p3);
        
        u1.getPapel().add(p1);
        usuarioDAO.update(u1);

        Site s1 = new Site();
        s1.setEmail("site1@site");
        s1.setNome("Site1");
        s1.setSenha(encoder.encode("123"));
        s1.setTelefone("0800-8899");
        s1.setUrl("site1.com");
        siteDAO.save(s1);
        s1.getPapel().add(p2);
        s1.setAtivo(true);
        siteDAO.update(s1);
        
        Site s2 = new Site();
        s2.setEmail("site2@site");
        s2.setNome("Site2");
        s2.setSenha(encoder.encode("123"));
        s2.setTelefone("0800-0000");
        s2.setUrl("site2.com");
        siteDAO.save(s2);
        s2.getPapel().add(p2);
        s2.setAtivo(true);
        siteDAO.update(s2);
        
        Site s3 = new Site();
        s3.setEmail("site3@site");
        s3.setNome("Site3");
        s3.setSenha(encoder.encode("123"));
        s3.setTelefone("0800-7410");
        s3.setUrl("site3.com");
        siteDAO.save(s3);
        s3.getPapel().add(p2);
        s3.setAtivo(true);
        siteDAO.update(s3);
        
        Site s4 = new Site();
        s4.setEmail("site4@site");
        s4.setNome("Site4");
        s4.setSenha(encoder.encode("123"));
        s4.setTelefone("0800-7896");
        s4.setUrl("site4.com");
        siteDAO.save(s4);
        s4.getPapel().add(p2);
        s4.setAtivo(true);
        siteDAO.update(s4);
        
        Teatro t1 = new Teatro();
        t1.setCidade("Campinas");
        t1.setCnpj("82.658.723/0001-47");
        t1.setEmail("teatro1@teatro");
        t1.setNome("Teatro1");
        t1.setSenha(encoder.encode("123"));
        teatroDAO.save(t1);
        t1.getPapel().add(p3);
        t1.setAtivo(true);
        teatroDAO.update(t1);
        
        Teatro t2 = new Teatro();
        t2.setCidade("Santa Adelia");
        t2.setCnpj("72.125.453/0001-55");
        t2.setEmail("teatro2@teatro");
        t2.setNome("Teatro2");
        t2.setSenha(encoder.encode("123"));
        teatroDAO.save(t2);
        t2.getPapel().add(p3);
        t2.setAtivo(true);
        teatroDAO.update(t2);
        
        Teatro t3 = new Teatro();
        t3.setCidade("Catanduva");
        t3.setCnpj("62.559.847/0001-68");
        t3.setEmail("teatro3@teatro");
        t3.setNome("Teatro3");
        t3.setSenha(encoder.encode("123"));
        teatroDAO.save(t3);
        t3.getPapel().add(p3);
        t3.setAtivo(true);
        teatroDAO.update(t3);
            
        Teatro t4 = new Teatro();
        t4.setCidade("Campinas");
        t4.setCnpj("25.222.208/0001-86");
        t4.setEmail("teatro4@teatro");
        t4.setNome("Teatro4");
        t4.setSenha(encoder.encode("123"));
        teatroDAO.save(t4);
        t4.getPapel().add(p3);
        t4.setAtivo(true);
        teatroDAO.update(t4);
        
        Teatro t5 = new Teatro();
        t5.setCidade("Catanduva");
        t5.setCnpj("62.383.193/0001-64");
        t5.setEmail("teatro5@teatro");
        t5.setNome("Teatro5");
        t5.setSenha(encoder.encode("123"));
        teatroDAO.save(t5);
        t5.getPapel().add(p3);
        t5.setAtivo(true);
        teatroDAO.update(t5);
        
        Teatro t6 = new Teatro();
        t6.setCidade("Santa Adelia");
        t6.setCnpj("78.496.845/0001-07");
        t6.setEmail("teatro6@teatro");
        t6.setNome("Teatro6");
        t6.setSenha(encoder.encode("123"));
        teatroDAO.save(t6);
        t6.getPapel().add(p3);
        t6.setAtivo(true);
        teatroDAO.update(t6);
        
        Teatro t7 = new Teatro();
        t7.setCidade("Londrina");
        t7.setCnpj("18.125.837/0001-22");
        t7.setEmail("teatro7@teatro");
        t7.setNome("Teatro7");
        t7.setSenha(encoder.encode("123"));
        teatroDAO.save(t7);
        t7.getPapel().add(p3);
        t7.setAtivo(true);
        teatroDAO.update(t7);
        
        
    }
}
