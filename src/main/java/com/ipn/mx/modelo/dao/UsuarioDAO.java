/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.entidades.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author leoj_
 */
public class UsuarioDAO {

    /*SCRIPT TABLA BASE DE DATOS
    
    create table Usuario(
        idUsuario serial primary key,
        nombre varchar(50) not null,
        paterno varchar(50) not null,
        materno varchar(50) not null,
        email varchar(50) not null,
        nombreUsuario varchar(50) not null,
        claveUsuario varchar(50) not null,
        tipoUsuario varchar(50) not null	
    );
        
    insert into Usuario (nombre, paterno, materno, email,nombreUsuario,claveUsuario,tipoUsuario) 
        values ('Jhon', 'Doe', 'Doe', 'jonhndoe@email.com', 'jhon', '12345678', '1');
        
    STORE PROCEDURES:
    ============================================================================
    
        create or replace function seleccionaTodoUsuario() returns Table(
            idUsuario int,
            nombre varchar,
            paterno varchar,
            materno varchar,
            email varchar,
            nombreUsuario varchar,
            claveUsuario varchar,
            tipoUsuario varchar
        ) as $$
                select * from Usuario;
        $$ language sql

        select seleccionaTodoUsuario();
    
    ============================================================================
    
    create or replace procedure spInsertarUsuario(
            nombre varchar,
            paterno varchar,
            materno varchar,
            email varchar,
            nombreUsuario varchar,
            claveUsuario varchar,
            tipoUsuario varchar    
    )
    language sql
    as $$
            insert into Usuario (nombre, paterno, materno, email,nombreUsuario,claveUsuario,tipoUsuario) 
        values (nombre, paterno, materno, email,nombreUsuario,claveUsuario,tipoUsuario);
    $$

    call spInsertarUsuario('Jhon', 'Doe', 'Doe', 'jonhndoe@email.com', 'jhon', '12345678', '1');
    
    ============================================================================
    
    create or replace procedure spActualizarUsuario(
            in nombre varchar,
            in paterno varchar,
            in materno varchar,
            in email varchar,
            in nombreUsuario varchar,
            in claveUsuario varchar,
            in tipoUsuario varchar,
            in id int
    )
    language sql
    as $$
            update Usuario set nombre=nombre, paterno=paterno, materno=materno, email=email, nombreUsuario=nombreUsuario, claveUsuario=claveUsuario, tipoUsuario=tipoUsuario where idUsuario=id;
    $$

    call spActualizarUsuario('Jhon', 'Sanchez', 'Doe', 'jhonsanchez@email.com', 'jhon', '12345678', '2', '2');
    
    ============================================================================
    
    create or replace procedure spEliminarUsuario(in id int)
    language sql
    as $$
            delete from Usuario where idUsuario=id;
    $$

    call spEliminarUsuario(2);
    
    ============================================================================
    
    create or replace function seleccionarUsuario(in id int) 
    returns Table(idUsuario integer,
                nombre character varying,
                materno character varying,
                paterno character varying,
                email character varying,
                nombreUsuario character varying,
                claveUsuario character varying,
                tipoUsuario character varying) 
    language sql
    as $function$
                select * from Usuario where idUsuario=id;
    $function$ 

    select seleccionarUsuario(1);
    
     */

    private final String SQL_INSERT = "call spInsertarUsuario(?,?,?,?,?,?,?)";
    private final String SQL_UPDATE = "call  spActualizarUsuario(?,?,?,?,?,?,?,?)";
    private final String SQL_DELETE = "call spEliminarUsuario(?)";
    private final String SQL_READ = "select * from seleccionarUsuario(?)";
    private final String SQL_READ_ALL = "select * from seleccionaTodoUsuario()";

    private Connection conexion;

    public Connection conectar() {
        String user = "iewcorrxmgvsmo";
        String pwd = "a7750a2841c65540faa134f8c25978da1ea8dd72aaca9a853f0c30f2ac424fb7";
        String url = "jdbc:postgresql://ec2-44-198-24-0.compute-1.amazonaws.com:5432/d5luuaqm2h0rv1";
        String pgDriver = "org.postgresql.Driver";

        try {
            Class.forName(pgDriver);
            conexion = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexion;
    }

    ;
    
    public void create(Usuario dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_INSERT);
            ps.setString(1, dto.getNombre());
            ps.setString(2, dto.getPaterno());
            ps.setString(3, dto.getMaterno());
            ps.setString(4, dto.getEmail());
            ps.setString(5, dto.getNombreUsuario());
            ps.setString(6, dto.getClaveUsuario());
            ps.setString(7, dto.getTipoUsuario());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }

            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void update(Usuario dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_UPDATE);
            ps.setString(1, dto.getNombre());
            ps.setString(2, dto.getPaterno());
            ps.setString(3, dto.getMaterno());
            ps.setString(4, dto.getEmail());
            ps.setString(5, dto.getNombreUsuario());
            ps.setString(6, dto.getClaveUsuario());
            ps.setString(7, dto.getTipoUsuario());
            ps.setInt(8, dto.getIdUsuario());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void delete(Usuario dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_DELETE);
            ps.setInt(1, dto.getIdUsuario());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public Usuario read(Usuario dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareCall(SQL_READ);
            ps.setInt(1, dto.getIdUsuario());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (Usuario) resultados.get(0);
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public List readAll() throws SQLException {
        conectar();
        CallableStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareCall(SQL_READ_ALL);
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados;
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();
        while (rs.next()) {
            Usuario dto = new Usuario();
            dto.setIdUsuario(rs.getInt("idUsuario"));
            dto.setNombre(rs.getString("nombre"));
            dto.setNombre(rs.getString("paterno"));
            dto.setNombre(rs.getString("materno"));
            dto.setNombre(rs.getString("email"));
            dto.setNombre(rs.getString("nombreUsuario"));
            dto.setNombre(rs.getString("claveUsuario"));
            dto.setTipoUsuario(rs.getString("tipoUsuario"));
            resultados.add(dto);
        }
        return resultados;
    }

    public static void main(String[] args) {

        UsuarioDAO dao = new UsuarioDAO();
        Usuario dto = new Usuario();

//        dto.getEntidad().setIdUsuario(1);
        dto.setNombre("Jose");
        dto.setPaterno("Jose");
        dto.setMaterno("Jose");
        dto.setEmail("jose@email.com");
        dto.setNombreUsuario("jose");
        dto.setClaveUsuario("jose123");
        dto.setTipoUsuario("2");

        System.out.println(dto);

        try {
            dao.create(dto);
            //dao.update(dto);
//            System.out.println(dao.readAll());
//            System.out.println(dao.read(dto));

//            dao.delete(dto);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
