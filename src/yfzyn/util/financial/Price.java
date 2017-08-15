package yfzyn.util.financial;

/**
 * 计算价格
 */
public class Price {

    private Price(){}

    /**
     * 计算本息总数：利益按日计算，按月还款，每月本金还款取月平均值（初略计算，每月30天）。
     * @param month 还款月数
     * @param dayRate 日利率
     * @param principal 本金
     * @return 本息总和
     */
    public static double principalAndInterest(int month, double dayRate, double principal){
        double total = 0;
        double iPrincipal = principal / month;
        int iMonth = 1;
        while (iMonth <= month){
            //计算当月利息
            double iInterest = interest(dayRate, 30, principal);
            //当月利息加应该还本经
            double iTotal = iInterest + iPrincipal;
            //前月总和
            total += iTotal;
            principal -= iPrincipal;
            iMonth++;
        }
        return total;

    }

    /**
     * 计算利息
     * @param dayRate 日利率
     * @param day 天数
     * @param principal 本金
     * @return 利息
     */
    public static double interest(double dayRate, int day, double principal){
        return principal * dayRate * day;
    }
}
