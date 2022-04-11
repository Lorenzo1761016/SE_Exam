/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1.soapserver;

import javax.jws.WebService;

/**
 *
 * @author biar
 */
@WebService(endpointInterface = "it.uniroma1.soapserver.WSInterface")
public class WSImpl implements WSInterface{
    
    @Override
    public Professor getDetails(String id) {
        return Professors.getProfessor(id);
    }
    
}
