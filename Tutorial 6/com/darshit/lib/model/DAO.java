package com.darshit.lib.model;

import java.util.*;
import com.darshit.lib.model.*;

public class DAO{

  public static ArrayList<Student> students = new ArrayList<Student>();
  public static ArrayList<Staff> staffs = new ArrayList<Staff>();
  public static ArrayList<HardMedia> hardMedia = new ArrayList<HardMedia>();
  public static ArrayList<SoftMedia> softMedia = new ArrayList<SoftMedia>();

  public static void initData(){
    students.add(new Student(1, 50, "Darshit", "CE", 5));
    students.add(new Student(2, 03, "Abhishek", "CE", 5));
    students.add(new Student(3, 38, "Parth", "CE", 5));
    students.add(new Student(4, 37, "Rushi", "CE", 5));
    students.add(new Student(5, 27, "Kuldip", "CE", 5));

    staffs.add(new Staff(1, "Girishsir", "CE", "Professor"));
    staffs.add(new Staff(2, "Sagarsir", "CE", "Professor"));
    staffs.add(new Staff(3, "Dipeshsir", "CE", "Professor"));
    staffs.add(new Staff(4, "Virajsir", "CE", "Professor"));
    staffs.add(new Staff(5, "Tejassir", "CE", "HOD"));

    hardMedia.add(new HardMedia(1, "a", "b", 250, "CE dept", 2, "language C"));
    hardMedia.add(new HardMedia(2, "c", "d", 300, "CE dept", 5, "language C++"));
    hardMedia.add(new HardMedia(3, "e", "f",  350, "CE dept", 5, "language Java"));
    hardMedia.add(new HardMedia(4, "g", "h", 400, "CE dept", 5, "language C#"));
    hardMedia.add(new HardMedia(5, "i", "j", 450, "CE dept", 5, "language .Net"));

    softMedia.add(new SoftMedia(1, "a", "2.0 mb", "D:-CE-books-", "language JS"));
    softMedia.add(new SoftMedia(2, "c", "3.1 mb","D:-CE-books-", "language Dart"));
    softMedia.add(new SoftMedia(3, "e", "4.2 mb","D:-CE-books-", "language Ruby"));
    softMedia.add(new SoftMedia(4, "g", "5.5 mb","D:-CE-books-", "language Kotlin"));
    softMedia.add(new SoftMedia(5, "i", "10.1 mb","D:-CE-books-", "language Php"));
  }
}
