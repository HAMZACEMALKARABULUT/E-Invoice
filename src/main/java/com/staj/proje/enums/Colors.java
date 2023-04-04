package com.staj.proje.enums;

public enum Colors {
  PURPLE("\u001B[35m"),
  RED("\u001B[31m"),
  GREEN("\u001B[32m"),
  YELLOW("\u001B[33m"),
  BLUE("\u001B[34m"),
  CYAN("\u001B[36m"),
  WHITE("\u001B[37m"),
  BLACK("\u001B[30m");


  private final String code;
  private final String lastCode="\u001B[0m";
public String getLastCode(){

  return lastCode;
}

  Colors(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

}
