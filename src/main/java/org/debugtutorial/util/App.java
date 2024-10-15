package org.debugtutorial.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Formatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choose;
        Formatter formatter = new Formatter();

        do {
            System.out.println("Выберите формат (1/2):");
            choose = in.nextInt();
        } while (choose != 1 && choose != 2);

        if (choose == 1) {            
            System.out.println("Введите x:");
            double x = in.nextDouble();
            int k;

            do {
                System.out.println("Введите положительное k:");
                k = in.nextInt();
            } while (k < 0);

            formatter.format("k в восьмеричном формате с флагом : %#o%n", k);
            formatter.format("k в шестнадцатеричном формате с флагом : %#x%n", k);

            if (Math.abs(x) > (2 * Math.PI)) {
                if (x >= 0) {
                    while (Math.abs(x) > (2 * Math.PI)) {
                        x -= (2 * Math.PI);
                    }
                } else {
                    while (Math.abs(x) > (2 * Math.PI)) {
                        x += (2 * Math.PI);
                    }
                }
            }

            int wid1 = 10;
            double cosin = 0;
            double slag = 1;
            double slag2 = -(Math.pow(x, 2));
            double eps = Math.pow(10, -k);
            int n = 2;

            while (true) {
                cosin += slag;
                slag *= (slag2 / (n * (n - 1)));
                n += 2;
                if (Math.abs(slag) <= eps) {
                    break;
                }
            }

            formatter.format("Косинус по формуле: %0+" + wid1 + "." + (k + 1) + "f%n", cosin);
            formatter.format("Косинус стандартный: %0+" + wid1 + "." + (k + 1) + "f%n", Math.cos(x));
            System.out.print(formatter);
            formatter.close();
            in.close();
        } else if (choose == 2) {
            System.out.println("Введите x (BigDecimal):");
            BigDecimal x = new BigDecimal(reader.readLine());

            BigInteger k;
            do {
                System.out.println("Введите положительное k (BigInteger):");
                k = new BigInteger(reader.readLine());
            } while (k.compareTo(BigInteger.ZERO) < 0);

            formatter.format("k в восьмеричном формате с флагом : %#o%n", k);
            formatter.format("k в шестнадцатеричном формате с флагом : %#x%n", k);

            BigDecimal twoPi = new BigDecimal(2 * Math.PI);
            while (x.abs().compareTo(twoPi) > 0) {
                if (x.compareTo(BigDecimal.ZERO) >= 0) {
                    x = x.subtract(twoPi);
                } else {
                    x = x.add(twoPi);
                }
            }
            int k1=k.intValue();
            k1*=(-1);
            double temp= (Math.pow(10, k1));
            int wid1 = 21;
            BigDecimal cosin = BigDecimal.ZERO;
            BigDecimal slag = BigDecimal.ONE;
            BigDecimal slag2 = x.multiply(x).negate();
            BigDecimal eps = BigDecimal.valueOf(temp);
            int n = 2;

            while (true) {
                cosin = cosin.add(slag);
                BigDecimal term = slag2.divide(BigDecimal.valueOf(n * (n - 1)), (k1*(-1)+1), RoundingMode.HALF_UP);
                slag = slag.multiply(term);
                n += 2;

                if (slag.abs().compareTo(eps) <= 0) {
                    break;
                }
            }

            formatter.format("Косинус по формуле: %0+" + wid1 + "." + (k.intValue() + 1) + "f%n", cosin);
            formatter.format("Косинус стандартный: %0+" + wid1 + "." + (k.intValue() + 1) + "f%n", Math.cos(x.doubleValue()));
            System.out.print(formatter);
            formatter.close();
        }
    }
    public static double calculateCosine(double x, int k) {
        if (Math.abs(x) > (2 * Math.PI)) {
			if (x >= 0) {
				while (Math.abs(x) > (2 * Math.PI)) {
					x -= (2 * Math.PI);
				}
			} else {
				while (Math.abs(x) > (2 * Math.PI)) {
					x += (2 * Math.PI);
				}
			}
		}
		double cosin = 0;
		double slag = 1;
		double slag2 = -(Math.pow(x, 2));
		double eps = Math.pow(10, -k);
		int n = 2;

		while (true) {
			cosin += slag;
			slag *= (slag2 / (n * (n - 1)));
			n += 2;
			if (Math.abs(slag) <= eps) {
				break;
			}
		}
        return cosin;
    }
	public static double calculateCosine2(double x1, String k1){
		BigDecimal x=new BigDecimal(x1);
		BigInteger k=new BigInteger(k1);
		BigDecimal twoPi = new BigDecimal(2 * Math.PI);
            while (x.abs().compareTo(twoPi) > 0) {
                if (x.compareTo(BigDecimal.ZERO) >= 0) {
                    x = x.subtract(twoPi);
                } else {
                    x = x.add(twoPi);
                }
            }
            int k2=k.intValue();
            k2*=(-1);
            double temp= (Math.pow(10, k2));
            BigDecimal cosin = BigDecimal.ZERO;
            BigDecimal slag = BigDecimal.ONE;
            BigDecimal slag2 = x.multiply(x).negate();
            BigDecimal eps = BigDecimal.valueOf(temp);
            int n = 2;

            while (true) {
                cosin = cosin.add(slag);
                BigDecimal term = slag2.divide(BigDecimal.valueOf(n * (n - 1)), (k2*(-1)+1), RoundingMode.HALF_UP);
                slag = slag.multiply(term);
                n += 2;

                if (slag.abs().compareTo(eps) <= 0) {
                    break;
                }
            }
		double res=cosin.doubleValue();
		return res;
	}
}
