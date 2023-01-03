package q9_enum;

/**
 * This is an example enum for use in categorizing the kind of driver's license someone may have in Utah.
 * Enums are good when you have a fixed and set number of categories for something (gender, etc.) and is used for
 * representing a group of named constants. (info from https://www.geeksforgeeks.org/enum-in-java/)
 */
public enum LicenceTypeEnum {
  CLASS_A,
  CLASS_B,
  CLASS_C,
  CLASS_D,
  DRIVING_PRIVILEGE_CARD,
  MOTORCYCLE_LICENCE,
  CDL;
}
