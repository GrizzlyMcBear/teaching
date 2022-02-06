package tests.exams.matriculation.cs.y2018.question14;

import java.util.Random;

/**
 * This is the solution to question #14 in the
 * <a href="http://blog.csit.org.il/UpLoad/FilesUpload/T381_2018.pdf">2018 matriculation (summer) exam</a>.
 * A revised solution could be found <a href="http://blog.csit.org.il/UpLoad/FilesUpload/pitaron_899381_2018.pdf">here</a>. 
 * @author Ronen Cohen
 */
public class Question14 {

	private static Random residentTypeSeed;
	
	public static void testSolution() {
		residentTypeSeed = new Random();
        Resident[] residents = new Resident[20];

        PopulateResidents(residents);
        PrintResidents(residents);
        PrintSeniorCitizensPropertyTax_1(residents);
        PrintSeniorCitizensPropertyTax_2(residents);
        PrintSeniorCitizensPropertyTax_3(residents);
	}
	
//	public static void PrintSeniorCitizensPropertyTax_1_Bad(Object[] a) {
//        for (int i = 0; i < a.length; i++)
//        {
//            if (a[i] instanceof SeniorCityResident) {
//                System.out.println(a[i].getName() + " " + a[i].getPropertyTax());
//            }
//        }
//    }

    public static void PrintSeniorCitizensPropertyTax_1(Object[] a) {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] instanceof SeniorCityResident) {
                System.out.println(((Resident)a[i]).getName() + " " + ((Resident)a[i]).getPropertyTax());
            }
        }
    }

    public static void PrintSeniorCitizensPropertyTax_2(IData[] a) {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] instanceof SeniorCityResident) {
                System.out.println(a[i].getName() + " " + a[i].getPropertyTax());
            }
        }
    }

    public static void PrintSeniorCitizensPropertyTax_3(Resident[] a) {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] instanceof SeniorCityResident) {
                System.out.println(a[i].getName() + " " + a[i].getPropertyTax());
            }
        }
    }

    public static void PrintResidents(Resident[] residents) {
        System.out.println("Residents:");
        for (Resident resident : residents) {
            System.out.println("+ Name: " + resident.getName() + ", Type: " + resident.getClass());
        }
    }

    public static void PopulateResidents(Resident[] residents) {
        for (int i = 0; i < residents.length; i++) {
            residents[i] = InstantiateResident();
        }
    }

    public static Resident InstantiateResident() {
        int residentType = residentTypeSeed.nextInt(3);
        Resident returnValue;

        switch (residentType) {
            case 0:
                returnValue = new CityResident();
                break;
            case 1:
                returnValue = new SeniorCityResident();
                break;
            case 2:
                returnValue = new VillageResident();
                break;
            default:
                returnValue = new CityResident();
                break;
        }

        return returnValue;
    }
}