/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.service;

import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kevingomes17
 */
public interface DaoService {   
    public <T> Boolean insert(T object);
    public <T> Boolean update(T object);
}
