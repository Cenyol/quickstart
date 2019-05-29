package com.cenyol.demo.rc;

import java.util.Comparator;

/**
 * @author Chenhanqun mail: mr.cenyol@gmail.com
 * @date 2019-05-27 17:27
 */
public class Extension {
    private String firstName;
    private String lastName;
    private String ext;
    private String extType;

    private Extension() {
    }

    public static Extension getInstance(String firstName, String lastName) {
        Extension extension = new Extension();
        extension.setFirstName(firstName);
        extension.setLastName(lastName);
        return extension;
    }

    public static Extension getInstanceWithExt(String firstName, String lastName, String ext, String extType) {
        Extension extension = new Extension();
        extension.setFirstName(firstName);
        extension.setLastName(lastName);
        extension.setExt(ext);
        extension.setExtType(extType);
        return extension;
    }

    public int comparatorForLastName(Extension other) {
        if (isNotDefine(this.getLastName())) {
            return 1;
        }
        if (isNotDefine(other.getLastName())) {
            return -1;
        }
        return this.getLastName().compareTo(other.getLastName());
    }

    public int comparatorForExt(Extension other) {
        if (isNotDefine(this.getExt())) {
            return 1;
        }
        if (isNotDefine(other.getExt())) {
            return -1;
        }
        return this.getExt().compareTo(other.getExt());
    }

    public int comparatorForExtType() {
        if (isNotDefine(getExtType())) {
            return Integer.MAX_VALUE;
        }
        return ExtTypeEnum.valueOf(getExtType()).ordinal();
    }

    private boolean isNotDefine(String str) {
        return str == null || str.equals("");
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getExtType() {
        return extType;
    }

    public void setExtType(String extType) {
        this.extType = extType;
    }

    @Override
    public String toString() {
        return "Extension{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ext='" + ext + '\'' +
                ", extType='" + extType + '\'' +
                '}';
    }
}
