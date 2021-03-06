/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jamde.estimator;

import jamde.distribution.Distribution;
import java.util.Arrays;

/**
 * Class is used for countDistance of KolmCramMEstimator and KolmCramBEstimator.
 *
 * @author honza
 */
public abstract class KolmCram extends Estimator{
    protected double p;
    protected double q;
    
    public KolmCram(int p, int q) {
        this.p = p;
        this.q = q;
    }
    
    /**
     * Method is called by KolmCramMEstimator and KolmCramBEstimator, because they choose m diferently.
     * 
     * @param distr
     * @param data
     * @param m
     * @return 
     */
    protected double countDistance(Distribution distr, double[] data, double m) {
        double dist = 0;
        double y,y1;
        int n = data.length;
        m = Math.min(m,n);
        double[] d = new double[n];
        double h = Math.max(n - m, 0);

        Arrays.sort(data);
        
        DistributionFunctionCont distributionFunctionCont = new DistributionFunctionCont(data);
        for (int i = 0; i < n; i++) {
            y = distr.getFunctionValue(data[i]);
            d[i] = Math.pow(Math.abs(((double) i + 1.0) / n - y), p/ q);
        }

        Arrays.sort(d);
        
        for (int i = d.length - 1; i >= h; i--) {
            dist = dist + d[i];
        }

        dist = dist / m;
        return dist;
    }

}
