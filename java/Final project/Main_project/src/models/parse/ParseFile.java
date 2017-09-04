/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.parse;

import java.util.ArrayList;
import models.entity.Doctors;

/**
 *
 * @author ya
 */
public interface ParseFile {
    
 public abstract ArrayList<Doctors> parse();
    
}
