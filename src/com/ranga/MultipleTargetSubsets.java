package com.ranga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultipleTargetSubsets {

    // Function to find the first subset with a given target sum
    public static List<Integer> findFirstSubsetSum(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        if (findSubset(nums, target, result, 0)) {
            return result;
        }
        return null; // No subset found
    }

    // Helper function to find the subset using backtracking
    private static boolean findSubset(int[] nums, int target, List<Integer> result, int start) {
        if (target == 0) {
            return true; // Found a subset
        }
        if (target < 0 || start >= nums.length) {
            return false; // Out of bounds or negative target
        }

        // Include nums[start] in the subset
        result.add(nums[start]);
        if (findSubset(nums, target - nums[start], result, start + 1)) {
            return true;
        }

        // Exclude nums[start] from the subset and backtrack
        result.remove(result.size() - 1);
        return findSubset(nums, target, result, start + 1);
    }

    // Function to remove the first occurrence of each element in subset from the array
    public static int[] removeSubset(int[] nums, List<Integer> subset) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }

        for (int num : subset) {
            numList.remove(Integer.valueOf(num));
        }

        // Convert list back to array
        int[] result = new int[numList.size()];
        for (int i = 0; i < numList.size(); i++) {
            result[i] = numList.get(i);
        }

        return result;
    }

    // Function to handle multiple target sums
    public static void processTargets(int[] nums, int[] targets) {
        int[] updatedArray = Arrays.copyOf(nums, nums.length); // Work on a copy of the original array

        for (int target : targets) {
            List<Integer> subset = findFirstSubsetSum(updatedArray, target);
            if (subset != null) {
                System.out.println("First subset with sum " + target + ": " + subset);
                updatedArray = removeSubset(updatedArray, subset);
                System.out.println("Array after removing the subset: " + Arrays.toString(updatedArray));
            } else {
                System.out.println("No subset with sum " + target + " found.");
            }
        }
    }

    public static void main(String[] args) {
        int[] targets = {46431, 248114, 46431, 170472, 46431};
        int[] nums  ={159936, 218324, 43378, 19937, 251601, 129767, 87803, 61017, 43256, 43256, 41999, 18819, 424128, 180105, 65409, 40023, 944927, 92138, 50309, 39966, 678472, 317565, 210817, 162111, 159640, 139828, 93016, 72703, 39910, 39910, 2190798, 882472, 315412, 314562, 159580, 156238, 153147, 117868, 73669, 50084, 44937, 40391, 39910, 39853, 201380, 130564, 134239, 117376, 119250, 41402, 20025, 227709, 213837, 158509, 115488, 90577, 89364, 85535, 75860, 64985, 42767, 41317, 42767, 41317, 39627, 39627, 19965, 66161, 138102, 49297, 290515, 215479, 40806, 40806, 2544445, 192790, 58656, 42157, 2291200, 91174, 81621, 40465, 149344, 130548, 106775, 37733, 27943, 19000, 6566745, 771122, 521575, 473640, 138697, 102545, 41974, 39444, 38835, 342409, 38241, 38326, 38778, 1364411, 280560, 125371, 93955, 68278, 41790, 41790, 35835, 208953, 918068, 117728, 79137, 83459, 76086, 41790, 19786, 41668, 41668, 5134950, 497400, 1804309, 2079781, 1408519, 207731, 192196, 52854, 41546, 38439, 38326, 156630, 170642, 138655, 134887, 102686, 41424, 39442, 41302, 41302, 39570, 506246, 366836, 172467, 97502, 78713, 41363, 41363, 38326, 3784237, 1834382, 376093, 385974, 279880, 106367, 76539, 37930, 33357, 62093, 2246174, 493425, 410932, 174008, 46597, 39016, 39333, 36151, 266448, 134020, 146738, 35598, 21194, 12574637, 287709, 158986, 110741, 61425, 42832, 42832, 35993, 3221387, 2019427, 457868, 371850, 435912, 222920, 183956, 143658, 143292, 132755, 97793, 85951, 61988, 40935, 40935, 37930, 29076, 17190, 1869556, 430776, 330532, 284474, 274179, 97076, 76200, 56810, 34018, 35914, 17070, 528315, 153893, 54061, 4904252, 115687, 127349, 112941, 420582, 367442, 171215, 80894, 69412, 37028, 168902, 44684, 1873866, 176377, 151973, 165219, 72745, 57088, 16165, 16008, 879064, 40264, 2690056, 98804, 92547, 42003, 40203, 16611, 4158003, 1561211, 300566, 41939, 40142, 40142, 40142, 37194, 37194, 155616, 74276, 36052, 2549719, 1093913, 162941, 111244, 32933, 37081, 37089, 83495, 15200, 500944, 184558, 146721, 97330, 75248, 42945, 30279, 31244, 17612, 21654, 19120, 14958, 16044, 9591, 322963, 409062, 218375, 152487, 70623, 73484, 33283, 39775, 15682, 1969550, 73597, 73597, 71088, 44009, 33782, 36798, 257469, 145156, 122680, 60409, 34256, 36741, 34256, 441205, 283138, 294850, 151011, 133436, 118827, 39409, 36885, 112440, 73216, 52515, 35377, 36515, 619839, 295088, 205924, 150474, 175393, 161461, 100341, 127607, 103683, 89972, 73075, 35362, 33861, 36232, 18879, 5221034, 569722, 357688, 211742, 228194, 223421, 169496, 104088, 82935, 49985, 46310, 41046, 41110, 39287, 2103251, 1012490, 705524, 659416, 392259, 311439, 363458, 189939, 179742, 183520, 183520, 142105, 72692, 43971, 52675, 39226, 39226, 36397, 36345, 17371, 20025, 20508, 15019, 19060, 17250, 18173, 532305, 564334, 419919, 120611, 100873, 78329, 72735, 56414, 62970, 54349, 37913, 36288, 39165, 34139, 20869, 20749, 737078, 397333, 303780, 198445, 182198, 144930, 72466, 44087, 39733, 39104, 11563, 42547, 35948, 241757, 138784, 85219, 6336477, 201631, 42322, 35320, 130601, 81016, 53840, 52019, 36454, 35893, 14824, 14886, 385542, 216998, 176756, 35436, 28914, 782542, 4065616, 40089, 26708, 1436875, 232303, 38371, 234335, 180258, 98443, 108154, 106491, 90129, 60884, 38310, 12671, 3140035, 335576, 161197, 74851, 35270, 326162, 152032, 58944, 35214, 1259429, 953351, 53073, 635312, 59543, 62121, 37882, 37882, 838775, 125418, 107444, 75504, 87400, 47641, 37699, 37699, 37699, 35477, 13171, 13354, 867776, 453661, 128114, 94962, 69900, 35204, 35190, 513182, 40072, 298665, 65781, 39959, 37455, 33987, 913945, 153577, 149046, 66475, 51737, 50297, 42697, 4998865, 3624866, 1272709, 1203091, 727861, 479771, 126887, 47101, 35075, 675331, 535262, 335165, 244718, 192544, 157577, 116706, 122560, 122157, 109023, 68310, 70034, 38877, 37211, 37211, 37211, 35017, 35017, 848519, 420055, 330619, 232497, 215106, 165130, 100684, 67122, 74177, 37150, 31583, 35017, 13906, 128642, 69689, 44813, 50026, 37028, 36844, 28669, 31703, 1346151, 450741, 34673, 30861, 314572, 207690, 183613, 57583, 13967, 13661, 14396, 12068, 41571, 303613, 220341, 116526, 77219, 62736, 36661, 36105, 68770, 64191, 44870, 32794, 362144, 107661, 40347, 38239, 30300, 267699, 287878, 272693, 101505, 36417, 36417, 36417, 36417, 34270, 33236, 34270, 34270, 34270, 11333, 1214329, 969298, 144183, 36356, 700133, 263128, 76151, 64395, 36234, 35625, 34898, 167771, 84290, 35273, 36173, 32112, 35166, 30219, 30225, 11884, 12007, 12742, 11299, 34041, 95638, 89936, 71979, 31857, 5310, 755298, 67621, 43767, 35929, 33811, 98771, 63101, 36922, 35264, 4132562, 3135015, 38844, 35806, 35806, 35806, 355606, 219248, 157579, 132709, 48047, 27294, 35501, 12038, 30493, 2959808, 412321, 277897, 258676, 107661, 137859, 55457, 34517, 35562, 34251, 13480, 637808, 367492, 100225, 35257, 808628, 452619, 116244, 116727, 70880, 33179, 2895412, 409393, 353791, 240291, 107491, 70758, 70758, 26144, 37454, 35318, 35379, 35135, 13893, 4234029, 3694725, 1895440, 1157358, 930257, 788641, 628588, 577743, 333674, 406407, 332359, 231847, 59727, 83253, 82745, 59773, 37858, 47181, 45638, 32036, 30919, 35318, 22420, 22420, 32030, 32949, 29096, 12007, 12435, 12497, 10843, 1151851, 600555, 284575, 314546, 66471, 66471, 31455, 32662, 580480, 421578, 203105, 35135, 2928377, 54985, 41632, 40341, 35347, 35459, 9809, 657823, 111253, 53571, 11884, 389801, 94536, 58835, 30322, 32432, 97984, 43271, 35999, 36134, 30067, 705823, 766488, 79793, 65207, 36198, 36198, 21440, 32144, 172927, 170018, 36134, 31235, 36134, 34585, 656880, 308237, 45933, 32017, 1595475, 340066, 301762, 305468, 34463, 171270, 56426, 53862, 38136, 33764, 27252, 15185, 6526580, 98623, 43858, 34219, 34219, 16199, 485747, 252356, 73755, 59166, 29300, 30893, 434873, 132024, 160434, 124435, 143171, 110493, 79450, 68194, 63139, 31800, 32087, 27332, 9495, 9985, 8915, 422198, 475268, 281400, 68071, 34036, 32030, 32030, 71906, 46398, 147889, 67339, 33791, 21337, 456533, 46233, 315696, 124831, 48780, 922126, 110541, 100642, 31512, 31455, 934894, 186936, 236359, 145884, 66436, 65750, 93319, 83692, 56554, 43834, 62654, 33874, 30997, 36100, 33425, 31455, 20723, 517973, 1361537, 1175228, 535894, 412659, 61289, 209334, 126502, 86067, 818707, 173676, 84416, 74735, 33181, 72878, 32815, 31693, 72323, 27596, 389135, 100340, 46234, 8589, 11605, 290189, 122185, 161480, 43773, 26998, 372790, 293503, 7962, 627751, 277091, 199326, 124773, 60955, 57930, 25580, 46153, 36847, 7523, 4521, 242402, 50784, 57409, 29066, 8527, 8715, 9154, 530405, 150108, 109978, 83112, 42429, 29370, 3572, 376233, 361493, 288188, 256167, 236760, 185041, 112774, 101551, 64041, 31178, 28408, 27975, 29427, 8652, 8464, 7411, 245751, 114284, 28625, 31960, 26231, 111184, 138289, 107529, 40894, 50859, 45552, 29609, 32098, 31899, 30723, 30723, 158564, 56457, 91815, 102053, 7962, 9727646, 1175941, 523108, 113604, 95722, 90903, 29426, 31852, 16847, 2888140, 1026746, 219831, 126026, 124269, 91286, 90757, 86926, 76941, 63519, 51270, 63187, 60857, 32374, 31593, 27535, 15577, 14951, 3968790, 1230922, 556504, 340634, 40410, 5705, 413048, 208279, 62033, 52605, 32094, 1709017, 89394, 1185577, 1349482, 966719, 143051, 30616, 30076, 24279, 30076, 133030, 39937, 7066, 75371, 469845, 119921, 66016, 3078, 93135, 102562, 87124, 45441, 44234, 25803, 29311, 2137230, 917466, 686511, 355969, 93812, 61599, 59328, 29429, 25536, 19294, 27472, 14801, 6646, 7147, 6332, 896377, 502966, 62421, 32115, 14420, 3713, 251153, 190946, 82228, 94759, 69591, 49707, 17248, 34267, 31987, 30616, 29488, 10533, 45927, 5637897, 115397, 19539, 2824028, 175867, 40210, 58623, 25180, 841650, 638828, 380065, 111990, 182234, 116539, 59723, 32360, 24015, 20177, 94971, 42709, 60622, 23930, 11661, 29076, 23048, 24942, 6207, 648901, 24144, 123553, 80777, 78917, 30250, 30250, 92816, 46276, 23760, 26519, 167187, 20616, 97674, 26122, 767237, 305509, 118558, 44783, 26122, 24467, 24052, 5205, 9159799, 4584176, 773562, 610432, 453837, 161526, 62402, 50000, 31024, 29884, 76611, 3604389, 1984402, 1021155, 191612, 80990, 123424, 72869, 71961, 57446, 30857, 29823, 29823, 831462, 1176840, 538451, 495482, 373417, 216085, 194774, 61639, 100531, 28664, 19326, 5392, 2496, 522145, 24616, 1390714, 41466, 16749, 210969, 452583, 449542, 277349, 74319, 29285, 28370, 2360, 0, 138911, 95046, 290341, 148958, 126608, 79621, 34827, 24884, 30647, 524220, 174012, 333019, 27782, 20536, 3170596, 1619601, 448278, 319989, 42931, 46783, 28852, 16928, 24434, 29090, 29090, 17814, 36698, 9081710, 514709, 295562, 277848, 135877, 140864, 75824, 47703, 38982, 29029, 27959, 27723, 29029, 81780, 27665, 27371, 8903, 6897, 2189589, 202348, 131648, 41656, 53104, 33862, 27723, 27458, 4025, 112579, 57447, 7429, 20704, 14042, 8579, 613662, 405623, 1670196, 56985, 21629, 43258, 2096182, 1019159, 155827, 126597, 89647, 68721, 57561, 37630, 29946, 28842, 28601, 5549, 9940, 55094, 2928103, 604163, 161362, 26708, 75489, 16668, 31253, 29818, 28289, 26893, 17149, 121135, 509401, 106272, 87363, 64655, 51887, 21890, 23197, 14972, 276686, 105757, 42848, 36780, 21118, 20339, 267824, 213780, 87897, 53683, 54388, 31442, 21974, 28473, 27194, 26893, 4733264, 1752082, 476805, 423527, 379894, 253600, 108541, 37502, 70772, 66008, 29499, 28174, 20947, 21681, 2011661, 257273, 210399, 162874, 45201, 76803, 48423, 34399, 54036, 26396, 13166, 29372, 27869, 20011, 3921, 221746, 40522, 3593, 55493, 1198274, 477591, 313281, 109247, 63210, 154068, 118641, 82085, 47657, 74872, 27451, 30650, 27869, 2291241, 829456, 318328, 316578, 40085, 96526, 87159, 79276, 76367, 75704, 68067, 65549, 51643, 23708, 22072, 22072, 21257, 21262, 27808, 20436, 27269, 2122865, 954526, 98335, 26783, 805526, 387086, 160694, 26783, 293056, 194272, 24692, 2653950, 538010, 122069, 75995, 29777, 32360, 26606, 25331, 704159, 131568, 71060, 66212, 19924, 19190, 2185, 87720, 163097, 274424, 238958, 171515, 137212, 57212, 56349, 28542, 28542, 28478, 27104, 28175, 27319, 29627, 6508, 0, 313216, 248846, 200202, 24852, 92697, 73250, 22022, 20122, 20549, 25943, 26253, 6895, 30333, 2570, 1294, 242894, 72992, 54028, 51155, 23148, 26953, 0, 919222, 274313, 99084, 66056, 28096, 27734, 26892, 26545, 49272, 161008, 129758, 51706, 29874, 565841, 153449, 106474, 26044, 53539, 23441, 26425, 2956, 1732085, 418965, 158962, 19822, 25548, 3364, 158787, 38284, 31805, 27649, 27649, 26464, 11659, 0, 115345, 27993, 3589, 92423, 83773, 55298, 51885, 22448, 19233, 3460, 130013, 68889, 101484, 7946, 18966, 26342, 643757, 79241, 120066, 22586, 104636, 26841, 52673, 64148, 26159, 26159, 5269, 91568, 78294, 31703, 27266, 24295, 26098, 26098, 18135, 25762, 25762, 1410, 1185043, 211816, 26218, 1089, 4828, 874539, 360222, 60038, 28459, 50792, 51393, 19504, 4211903, 661361, 86883, 22360, 35574, 29806, 15475, 1474, 129551, 57332, 58486, 19511, 18004, 17532, 334713, 8915, 25095, 14342, 18948, 187959, 82634, 25035, 3534, 1341612, 203870, 127419, 127419, 123952, 76451, 9292, 21801, 50967, 18389, 26625, 25484, 25484, 22714, 962784, 104215, 414717, 111573, 57557, 25240, 833, 619, 20659, 0, 168126, 332118, 23469, 92317, 82564, 24795, 24735, 1078774, 1596, 6464, 5402816, 36670, 171458, 36595, 33866, 40104, 25925, 5673, 83625, 16605, 24692, 866188, 260013, 250721, 152336, 151306, 17829, 39681, 16437, 25734, 24631, 16002, 24631, 24692, 19589, 215, 220, 73528, 49019, 84467, 82426, 15747, 19237, 31324, 48034, 15966, 24388, 649, 17461, 31399, 564, 28497, 18995, 1730, 2111, 349864, 15764, 24266, 18891, 1542863, 15826, 97592, 66275, 15397, 61};

        processTargets(nums, targets);
    }
}
