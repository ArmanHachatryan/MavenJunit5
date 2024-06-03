package org.aston.exercise;

import lombok.SneakyThrows;
import org.aston.exercise.infoService.Entity.BugReport;
import org.aston.exercise.infoService.Entity.BugReportAttachment;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
//        entityManager.getTransaction().begin();
//
//        List<BugReport> bugReportList = entityManager.createQuery("SELECT b FROM bug_report AS b").getResultList();
//        List<BugReportAttachment> bugReportAttachmentList = entityManager.createQuery("SELECT bug_id FROM public.bug_report_attachments", BugReportAttachment.class)
//                .getResultList();
//
//        bugReportList.forEach(System.out::println);
//
//        bugReportAttachmentList.forEach(System.out::println);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//
//        JPAUtil.shutdown();

//        int[] a = {4, 5 ,6 ,2 ,3};
//
//        for (int wall = a.length - 1; wall > 0; wall--)
//        {
//            int largest = 0;
//            for (int i = 1; i <= wall; i++)
//            {
//                if (a[largest] < a[i])
//                {
//                    largest = i;
//                }
//            }
//            exch(a, wall, largest);
//        }
//
//        for (var k : a) {
//            System.out.println(k);
//        }


        System.out.println(substring("hello", "lo"));

    }

    public static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int Search(char[] pat, char[] txt)
    {


        int M = pat.length;
        int N = txt.length;

        for (int i = 0; i <= N - M; i++)
        {
            int j;
            for(j = 0; j < M; j++)
            {
                if (txt[i + j] != pat[j])
                    break;
            }
            if (j == M) return i;
        }

        return -1;
    }


    public static int substring(String string, String substring) {

        char[] stringCharArray = string.toCharArray();
        char[] substringCharArray = substring.toCharArray();

        int S = stringCharArray.length;
        int B = substringCharArray.length;

        for (int i = 0; i <= S - B; i++ ) {
            int j;
            for (j = 0; j < B; j++) {
                if (stringCharArray[i + j] != substringCharArray[j])
                    break;
            }

            if (j == B) return i;
        }

        return -1;
    }
}