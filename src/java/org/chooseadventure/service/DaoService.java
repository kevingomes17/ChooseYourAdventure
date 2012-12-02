/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.service;

/**
 *
 * @author kevingomes17
 */
public interface DaoService {   
    public <T> Boolean insert(T object);
    public <T> Boolean update(T object);
}
