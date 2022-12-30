import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class tasks3 {

    public static void main(String[] args) {
        System.out.println("Задание 1");
        System.out.println(solutions(1, 0, -1));
        System.out.println(solutions(1, 0, 0));
        System.out.println(solutions(1, 0, 1));


        System.out.println("Задание 2");
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(findZip("all zip files are compressed"));


        System.out.println("Задание 3");
        System.out.println(checkPerfect(6));
        System.out.println(checkPerfect(28));
        System.out.println(checkPerfect(496));
        System.out.println(checkPerfect(12));
        System.out.println(checkPerfect(97));


        System.out.println("Задание 4");
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(flipEndChars("ada"));
        System.out.println(flipEndChars("Ada"));
        System.out.println(flipEndChars("z"));
        System.out.println(flipEndChars("Help me, please"));


        System.out.println("Задание 5");
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(isValidHexCode("#EAECEE"));
        System.out.println(isValidHexCode("#eaecee"));
        System.out.println(isValidHexCode("#CD5C58C"));
        System.out.println(isValidHexCode("#CD5C5Z"));
        System.out.println(isValidHexCode("#CD5C&C"));
        System.out.println(isValidHexCode("CD5C5C"));


        System.out.println("Задание 6");
        int[] mas1_1 = {1, 3, 4, 4, 4};
        int[] mas1_2 = {2, 5, 7};
        System.out.println(same(mas1_1, mas1_2));

        int[] mas2_1 = {9, 8, 7, 6};
        int[] mas2_2 = {4, 4, 3, 1};
        System.out.println(same(mas2_1, mas2_2));

        int[] mas3_1 = {2};
        int[] mas3_2 = {3, 3, 3, 3, 3};
        System.out.println(same(mas3_1, mas3_2));


        System.out.println("Задание 7");
        System.out.println(isKaprekar(3));
        System.out.println(isKaprekar(5));
        System.out.println(isKaprekar(297));


        System.out.println("Задание 8");
        System.out.println(longestZero("01100001011000"));
        System.out.println(longestZero("100100100"));
        System.out.println(longestZero("11111"));


        System.out.println("Задание 9");
        System.out.println(nextPrime(12));
        System.out.println(nextPrime(24));
        System.out.println(nextPrime(11));


        System.out.println("Задание 10");
        System.out.println(rightTriangle(3, 4, 5));
        System.out.println(rightTriangle(145, 105, 100));
        System.out.println(rightTriangle(70, 130, 110));
    }


    //Квадратное уравнение ax2 + bx + c = 0 имеет либо 0, либо 1, либо 2 различных
//решения для действительных значений x. учитывая a, b и c, вы должны вернуть
//число решений в уравнение.
    public static Integer solutions(int a, int b, int c) {
        int D = b * b - 4 * a * c;
        if (D > 0) {
            return 2;
        } else if (D == 0) {
            return 1;
        }
        return 0;
    }


//    Напишите функцию, которая возвращает позицию второго вхождения " zip " в
//    строку, или -1, если оно не происходит по крайней мере дважды. Ваш код должен
//    быть достаточно общим, чтобы передать все возможные случаи, когда "zip" может
//    произойти в строке
    public static Integer findZip(String s) {
        int ind = s.indexOf("zip", s.indexOf("zip") + 1);
        return ind;
    }


//    Создайте функцию, которая проверяет, является ли целое число совершенным
//    числом или нет. Совершенное число - это число, которое можно записать как
//    сумму его множителей, исключая само число.
    public static Boolean checkPerfect(int num) {
        int temp = 1;
        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0) {
                temp += i;
                temp += (num / i);
            }
        }
        return num == temp;
    }


//    Создайте функцию, которая принимает строку и возвращает новую строку с
//    заменой ее первого и последнего символов, за исключением трех условий:
//            – Если длина строки меньше двух, верните "несовместимо".".
//            – Если первый и последний символы совпадают, верните "два-это пара.".

    public static String flipEndChars(String s) {
        if (s.length() < 2) {
            String answer = "Incompatible.";
            return answer;
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            String answer = "Two's a pair.";
            return answer;
        }
        char swap = s.charAt(0);
        char swapB = s.charAt(s.length() - 1);
        String new_s = s.replace(swap, swapB);
        String new_s1 = new_s.substring(0, new_s.length() - 1);
        String new_s2 = new_s1 + swap;
        return new_s2;
    }


    //    Создайте функцию, которая определяет, является ли строка допустимым
//    шестнадцатеричным кодом.
//    Шестнадцатеричный код должен начинаться с фунтового ключа # и иметь длину ровно 6
//    символов. Каждый символ должен быть цифрой от 0-9 или буквенным символом от A-F.
//    все буквенные символы могут быть прописными или строчными.
    public static Boolean isValidHexCode(String s) {
        String allow_simb = "1234567890ABCDEFabcdef";
        if (s.charAt(0) != '#' || s.length() == 6 + 1) {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            if (allow_simb.indexOf(s.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }


    //    Напишите функцию, которая возвращает true, если два массива имеют одинаковое
//    количество уникальных элементов, и false в противном случае.
    public static Boolean same(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : arr1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i : arr2) {
            set2.add(i);
        }
        return set1.size() == set2.size();
    }


//    Число Капрекара-это положительное целое число, которое после возведения в
//    квадрат и разбиения на две лексикографические части равно сумме двух
//    полученных новых чисел:
//            – Если количество цифр квадратного числа четное, то левая и правая части будут иметь
//    одинаковую длину.
//            – Если количество цифр квадратного числа нечетно, то правая часть будет самой длинной
//    половиной, а левая-самой маленькой или равной нулю, если количество цифр равно 1.
    public static Boolean isKaprekar(int n) {
        int num = n*n;
        String temp = Integer.toString(num);

        String left = null;
        String right = null;

        int len = temp.length();
        if (len%2 == 0) {
            left = temp.substring(0, len/2);
            right = temp.substring(len/2);
        }
        else {
            left = temp.substring(0, (len-1)/2);
            if (left.equals("")) {
                left = "0";
            }
            right = temp.substring((len-1)/2);
            if (right.equals("")) {
                right = "0";
            }
        }

        return Integer.parseInt(left) + Integer.parseInt(right) == n;
    }


    // Напишите функцию, которая возвращает самую длинную последовательность
    //последовательных нулей в двоичной строке.
    public static String longestZero(String s) {
        String[] zeroes = s.split("1+");
        if (zeroes.length == 0) {
            return "";
        }
        Arrays.sort(zeroes);
        return zeroes[zeroes.length - 1];
    }


    // Если задано целое число, создайте функцию, которая возвращает следующее
    //простое число. Если число простое, верните само число.
    public static Integer nextPrime(int num) {
        int prime = 0;
        for (int i = num; i < num + 10; i++) {
            boolean flag = true;
            for (int k = 2; k <= i / k; k++) {
                if ((i % k) == 0) {
                    flag = false;
                }
            }
            if (flag) {
                prime= i;
                break;
            }
        }
        return prime;
    }


//    Учитывая три числа, x, y и z, определите, являются ли они ребрами
//    прямоугольного треугольника.
    public static Boolean rightTriangle(int a, int b, int c) {
        Boolean check1 = a*a == b*b+c*c;
        Boolean check2 = b*b == a*a+c*c;
        Boolean check3 = c*c == b*b+a*a;
        return check1 || check2 || check3;
    }
}

