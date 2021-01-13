/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author hoaktse05446
 */
public class Pagger {

    private static String generateHyperlink(String label, String urlFormat, int page) {
        return "<a href=\"" + urlFormat + page + "\">" + label + "</a>";
    }

    public static String generate(int pageIndex, int pageSize, int total, String urlFormat, int gap) {
        
        //get total of pages
        int numberOfPage = total / pageSize + (total % pageSize == 0 ? 0 : 1);
        String result = "";
        
        //if only have 1 page => no paging
        if (numberOfPage == 1) {
            return result;
        }

        //if current page > gap +1 => generate first page
        if (pageIndex > gap + 1) {
            result += generateHyperlink("First", urlFormat, 1);
        }

        //generate pages from (gap) pages before current page to (gap) pages after current page
        //if be current page => not a link
        for (int i = pageIndex - gap; i <= pageIndex + gap; i++) {
            if (i > 0 && i != pageIndex && i <= numberOfPage) {
                result += "\t" + generateHyperlink("" + i, urlFormat, i);
            } else if (i == pageIndex) {
                result += "\t" + pageIndex;
            }
        }

        //after generating before pages => remain page => show last page
        if (pageIndex < numberOfPage - gap) {
            result += "\t" + generateHyperlink("Last", urlFormat, numberOfPage);
        }
        return result;
    }
}
