package com.darshit.lib.model;

import com.darshit.lib.model.*;

public class DAO{
  public static Student students[] = new Student[5];
  public static Staff staffs[] = new Staff[5];
  public static SoftMedia softMedia[] = new SoftMedia[5];
  public static HardMedia hardMedia[] = new HardMedia[5];

  public static void initData(){
    students[0] = new Student(1, 50, "Darshit", "CE", 5);
    students[1] = new Student(2, 03, "Abhishek", "CE", 5);
    students[2] = new Student(3, 38, "Parth", "CE", 5);
    students[3] = new Student(4, 37, "Rushi", "CE", 5);
    students[4] = new Student(5, 27, "Kuldip", "CE", 5);

    staffs[0] = new Staff(1, "Girishsir", "CE", "Professor");
    staffs[1] = new Staff(2, "Sagarsir", "CE", "Professor");
    staffs[2] = new Staff(3, "Dipeshsir", "CE", "Professor");
    staffs[3] = new Staff(4, "Virajsir", "CE", "Professor");
    staffs[4] = new Staff(5, "Tejassir", "CE", "HOD");

    hardMedia[0] = new HardMedia(1, "a", "b", 250, "CE dept", 2, "language C");
    hardMedia[1] = new HardMedia(2, "c", "d", 300, "CE dept", 5, "language C++");
    hardMedia[2] = new HardMedia(3, "e", "f",  350, "CE dept", 5, "language Java");
    hardMedia[3] = new HardMedia(4, "g", "h", 400, "CE dept", 5, "language C#");
    hardMedia[4] = new HardMedia(5, "i", "j", 450, "CE dept", 5, "language .Net");

    softMedia[0] = new SoftMedia(1, "a", "2.0 mb", "D:-CE-books-", "language JS");
    softMedia[1] = new SoftMedia(2, "c", "3.1 mb","D:-CE-books-", "language Dart");
    softMedia[2] = new SoftMedia(3, "e", "4.2 mb","D:-CE-books-", "language Ruby");
    softMedia[3] = new SoftMedia(4, "g", "5.5 mb","D:-CE-books-", "language Kotlin");
    softMedia[4] = new SoftMedia(5, "i", "10.1 mb","D:-CE-books-", "language Php");
  }
}
