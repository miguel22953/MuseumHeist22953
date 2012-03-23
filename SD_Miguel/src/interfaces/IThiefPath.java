/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.OrdinaryThief;

/**
 *
 * @author Miguel
 */
public interface IThiefPath {
    void waitOutside(int thiefId);
    boolean crawlOut(OrdinaryThief p);
    boolean crawlIn(OrdinaryThief p);
}
