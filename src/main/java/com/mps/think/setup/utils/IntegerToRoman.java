package com.mps.think.setup.utils;

import java.text.DateFormat.Field;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import io.jsonwebtoken.lang.Arrays;

public class IntegerToRoman {
	public static String intToRoman(int num) {
		System.out.println("Integer: " + num);
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] romanLetters = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		StringBuilder roman = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			while (num >= values[i]) {
				num = num - values[i];
				roman.append(romanLetters[i]);
			}
		}
		System.out.println("Corresponding Roman Numerals is: " + roman.toString());
		return roman.toString();
	}

	public static String intToSmallRoman(int num) {
		System.out.println("Integer: " + num);
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] romanLetters = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		StringBuilder roman = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			while (num >= values[i]) {
				num = num - values[i];
				roman.append(romanLetters[i]);
			}
		}
		System.out.println("Corresponding Roman Numerals is: " + roman.toString().toLowerCase());
		return roman.toString().toLowerCase();
	}

	public static String intToabcd(int n) {
		System.out.println("Integer: " + n);
		String value = null;
		if (n > 0 && n < 27) {
			char ch = (char) (n + 64);
			value = "" + ch;
			System.out.println("Corresponding letter = " + value.toLowerCase());
		} else {
			System.out.println("Please enter a number in 1 to 26 range");
			return "";
		}
		return value.toLowerCase();
	}

	public static String intToABCD(int n) {
		System.out.println("Integer: " + n);
		String value = null;
		if (n > 0 && n < 27) {
			char ch = (char) (n + 64);
			value = "" + ch;
			System.out.println("Corresponding letter = " + value.toUpperCase());
		} else {
			System.out.println("Please enter a number in 1 to 26 range");
			return "";
		}
		return value.toUpperCase();
	}

	public static String[] comaSplitvalue(String comaValue) {

		String[] data = comaValue.split(",");
		for (String string : data) {

			System.out.println(string);
		}
		return data;
	}

	public static List<String> MonthOfTheYear(String comaValue, String nthdate, int year) {
		String value;
		List<String> list = new ArrayList<>();
		String[] data = comaValue.split(",");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < data.length; j++) {
				value = nthdate + "/" + data[j] + "/" + year;
				list.add(value);
				if (i == 5) {
					break;
				}
				i++;
			}
			year = year + 1;
		}
		System.out.println(list);
		return list;

	}

	static List<LocalDate> WeekOfTheYear(String comaValue, int day) {
		List<LocalDate> list = new ArrayList<>();
		int k = 0;
		String[] data = comaValue.split(",");
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < data.length; j++) {
				int calendarWeek = Integer.parseInt(data[j]);
				if (day == 0) {
					if (k < data.length) {
						LocalDate desiredDate = LocalDate.now().with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
						list.add(desiredDate);
					} else {
						LocalDate desiredDate = LocalDate.now().plusYears(1)
								.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
						list.add(desiredDate);
					}
				}
				if (day == 1) {
					if (k < data.length) {
						LocalDate desiredDate = LocalDate.now().with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
						list.add(desiredDate);
					} else {
						LocalDate desiredDate = LocalDate.now().plusYears(1)
								.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
						list.add(desiredDate);
					}

				}
				if (day == 2) {
					if (k < data.length) {
						LocalDate desiredDate = LocalDate.now().with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.TUESDAY));
						list.add(desiredDate);
					} else {
						LocalDate desiredDate = LocalDate.now().plusYears(1)
								.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.TUESDAY));
						list.add(desiredDate);
					}
				}
				if (day == 3) {
					if (k < data.length) {
						LocalDate desiredDate = LocalDate.now().with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.WEDNESDAY));
						list.add(desiredDate);
					} else {
						LocalDate desiredDate = LocalDate.now().plusYears(1)
								.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.WEDNESDAY));
						list.add(desiredDate);
					}
				}
				if (day == 4) {
					if (k < data.length) {
						LocalDate desiredDate = LocalDate.now().with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.THURSDAY));
						list.add(desiredDate);
					} else {
						LocalDate desiredDate = LocalDate.now().plusYears(1)
								.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.THURSDAY));
						list.add(desiredDate);
					}
				}
				if (day == 5) {
					if (k < data.length) {
						LocalDate desiredDate = LocalDate.now().with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY));
						list.add(desiredDate);
					} else {
						LocalDate desiredDate = LocalDate.now().plusYears(1)
								.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY));
						list.add(desiredDate);
					}
				}
				if (day == 6) {
					if (k < data.length) {
						LocalDate desiredDate = LocalDate.now().with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.SATURDAY));
						list.add(desiredDate);
					} else {
						LocalDate desiredDate = LocalDate.now().plusYears(1)
								.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.SATURDAY));
						list.add(desiredDate);
					}
				}
				if (i == 7) {
					break;
				}
				i++;
				k++;
			}
		}
		System.out.println(list);
		return list;
	}

	static List<LocalDate> WeekOfTheMonth(String comaValue, int day) {
		List<LocalDate> list = new ArrayList<>();
		int k = 0;
		String[] data = comaValue.split(",");
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < data.length; j++) {
				int calendarWeek = Integer.parseInt(data[j]);
				if (day == 0) {
					if (k < data.length) {
						LocalDate desiredDate = LocalDate.now().with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
						list.add(desiredDate);
					} else {
						LocalDate desiredDate = LocalDate.now().plusYears(1)
								.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)

								.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
						list.add(desiredDate);
					}
				}
				if (day == 1) {
					if (k < data.length) {
						LocalDate desiredDate = LocalDate.now().with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
						list.add(desiredDate);
					} else {
						LocalDate desiredDate = LocalDate.now().plusYears(1)
								.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
						list.add(desiredDate);
					}

				}
				if (day == 2) {
					if (k < data.length) {
						LocalDate desiredDate = LocalDate.now().with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.TUESDAY));
						list.add(desiredDate);
					} else {
						LocalDate desiredDate = LocalDate.now().plusYears(1)
								.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.TUESDAY));
						list.add(desiredDate);
					}
				}
				if (day == 3) {
					if (k < data.length) {
						LocalDate desiredDate = LocalDate.now().with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.WEDNESDAY));
						list.add(desiredDate);
					} else {
						LocalDate desiredDate = LocalDate.now().plusYears(1)
								.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.WEDNESDAY));
						list.add(desiredDate);
					}
				}
				if (day == 4) {
					if (k < data.length) {
						LocalDate desiredDate = LocalDate.now().with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.THURSDAY));
						list.add(desiredDate);
					} else {
						LocalDate desiredDate = LocalDate.now().plusYears(1)
								.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.THURSDAY));
						list.add(desiredDate);
					}
				}
				if (day == 5) {
					if (k < data.length) {
						LocalDate desiredDate = LocalDate.now().with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY));
						list.add(desiredDate);
					} else {
						LocalDate desiredDate = LocalDate.now().plusYears(1)
								.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY));
						list.add(desiredDate);
					}
				}
				if (day == 6) {
					if (k < data.length) {
						LocalDate desiredDate = LocalDate.now().with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.SATURDAY));
						list.add(desiredDate);
					} else {
						LocalDate desiredDate = LocalDate.now().plusYears(1)
								.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
								.with(TemporalAdjusters.previousOrSame(DayOfWeek.SATURDAY));
						list.add(desiredDate);
					}
				}
				if (i == 7) {
					break;
				}
				i++;
				k++;
			}
		}
		System.out.println(list);
		return list;
	}

	static void xyz(String comaValue, int day) {
		int mnth = 1;
		LocalDate todaysDate = LocalDate.now();
		System.out.println("today date : " + todaysDate);
		System.out.println("current day : " + todaysDate.getDayOfWeek().getValue());
		System.out.println("current week : " + todaysDate.getYear());
		System.out.println("current month : " + todaysDate.getMonth().getValue());
		LocalDate todaysDate1 = LocalDate.of(todaysDate.getYear(), todaysDate.getMonth().getValue(),
				todaysDate.getDayOfWeek().getValue());
		// int
		// weekofyear=todaysDate1.get(WeekFields.of(Locale.US).weekOfYear());
		int weekofyear = todaysDate1.get(WeekFields.of(Locale.US).weekOfMonth());
		System.out.println("@@@@@@@@@: " + weekofyear);

		List<LocalDate> list = new ArrayList<>();
		int k = 0;
		String[] data = comaValue.split(",");
		for (int i = 1; i <= 12; i++) {
//			if (todaysDate.getMonth().getValue() <= i) {
				for (int j = 0; j < data.length; j++) {
					int calendarWeek = Integer.parseInt(data[j]);
					if (calendarWeek >= weekofyear && todaysDate.getMonth().getValue() <= i) {
						if (day == 0) {
							if (k < data.length) {
								LocalDate desiredDate = LocalDate.now()
										.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
										.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
								list.add(desiredDate);
							} else {
								LocalDate desiredDate = LocalDate.now().plusYears(1)
										.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)

										.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
								list.add(desiredDate);
								System.out.println(desiredDate.getDayOfYear());
							}
						}
						if (day == 1) {
							if (k < data.length) {
								LocalDate desiredDate = LocalDate.now()
										.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
										.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
								list.add(desiredDate);
							} else {
								LocalDate desiredDate = LocalDate.now().plusYears(1)
										.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
										.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
								list.add(desiredDate);
							}

						}
						if (day == 2) {
							if (k < data.length) {
								LocalDate desiredDate = LocalDate.now()
										.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
										.with(TemporalAdjusters.previousOrSame(DayOfWeek.TUESDAY));
								list.add(desiredDate);
							} else {
								LocalDate desiredDate = LocalDate.now().plusYears(1)
										.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
										.with(TemporalAdjusters.previousOrSame(DayOfWeek.TUESDAY));
								list.add(desiredDate);
							}
						}
						if (day == 3) {
							if (k < data.length) {
								LocalDate desiredDate = LocalDate.now()
										.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
										.with(TemporalAdjusters.previousOrSame(DayOfWeek.WEDNESDAY));
								list.add(desiredDate);
							} else {
								LocalDate desiredDate = LocalDate.now().plusYears(1)
										.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
										.with(TemporalAdjusters.previousOrSame(DayOfWeek.WEDNESDAY));
								list.add(desiredDate);
							}
						}
						if (day == 4) {
							if (k < data.length) {
								LocalDate desiredDate = LocalDate.now()
										.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
										.with(TemporalAdjusters.previousOrSame(DayOfWeek.THURSDAY));
								list.add(desiredDate);
							} else {
								LocalDate desiredDate = LocalDate.now().plusYears(1)
										.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
										.with(TemporalAdjusters.previousOrSame(DayOfWeek.THURSDAY));
								list.add(desiredDate);
							}
						}
						if (day == 5) {
							if (k < data.length) {
								LocalDate desiredDate = LocalDate.now()
										.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
										.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY));
								list.add(desiredDate);
							} else {
								LocalDate desiredDate = LocalDate.now().plusYears(1)
										.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
										.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY));
								list.add(desiredDate);
							}
						}
						if (day == 6) {
							if (k < data.length) {
								LocalDate desiredDate = LocalDate.now()
										.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
										.with(TemporalAdjusters.previousOrSame(DayOfWeek.SATURDAY));
								list.add(desiredDate);
							} else {
								LocalDate desiredDate = LocalDate.now().plusYears(1)
										.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
										.with(TemporalAdjusters.previousOrSame(DayOfWeek.SATURDAY));
								list.add(desiredDate);
							}
						}
					} else {
						System.out.println("skip week!");
					}
					if (i == 7) {
						break;
					}
					i++;
					k++;
				}
//			} else {
//				System.out.println("skip month !");
//			}
		}
		System.out.println(list);
	}
	
	public static String getLastFourDigits(String creditCardNumber) {
        int length = creditCardNumber.length();
        if (length >= 4) {
            return creditCardNumber.substring(length - 4);
        } else {
            // Handle cases where the credit card number has less than 4 digits
            return creditCardNumber;
        }
    }
	
	public static String getMonthYear(Date vaildTo) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

    try {
//        Date date = dateFormat.parse(vaildTo);
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

        String month = monthFormat.format(vaildTo);
        String year = yearFormat.format(vaildTo);
//        String[] monthYear= {month,year};

        System.out.println("Month: " + month);
        System.out.println("Year: " + year);
        return month+"@"+year;
    } catch (Exception e) {
        System.out.println("Invalid date format");
        String[] tempdisp={"invalid" ,"date"};
        return "Invalid date format";
    }
    
	}

//	public static void main(String args[]) {
//		//// intToabcd(1);
//		//// intToabcd(4);
//		//// intToabcd(10);
//		//// intToabcd(31);
//		// comaSplitvalue("2,3,4,5");
//		MonthOfTheYear("4,8,12", "5", 2023);
//		// WeekOfTheYear("13,26,39,52","1",2023);
//		// WeekOfTheYear();
//		WeekOfTheYear("10,18,34,42,52", 1);
//		xyz("1,3", 1);
//	}

}