package org.example.article.controller;

import org.example.article.entity.Article;
import org.example.container;
import org.example.member.entity.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArticleController {
    List<Article> articleList = new ArrayList<>();
    int lastId = 1;
    Member loginMember;

    public void write() {
        if (loginMember == null) {
            System.out.println("== 비회원은 게시글 작성을 할 수 없습니다 ==");
            return;
        }
        System.out.print("제목: ");
        String title = container.getSc().nextLine();
        System.out.print("내용: ");
        String body = container.getSc().nextLine();

        System.out.println("== 게시글 작성이 완료되었습니다 ==");
        Article article = new Article(lastId, title, body, loginMember.getUserId());
        articleList.add(article);
        lastId++;
    }

    public void list() {
        if (articleList.size() == 0) {
            System.out.println("작성된 게시글이 없습니다.");
        } else {
            System.out.printf("번호 / 제목 / 내용 / 글 작성자 \n");
            for (int i = 0; i < articleList.size(); i++) {
                Article article = articleList.get(i);
                System.out.printf("%d / %s / %s / %s \n", article.getId(), article.getTitle(), article.getBody(), article.getUserId());
            }
        }
    }

    public void remove() {
        if (articleList.size() == 0) {
            System.out.println("작성된 게시글이 없습니다.");
        } else {
            int id = container.getSc().nextInt();
            System.out.print("삭제할 글 번호: ");
            for (int i = 0; i < articleList.size(); i++) {
                Article article = articleList.get(i);
                if (article.getId() == id) {
                    articleList.remove(article);
                }
            }
        }
    }

    public void modify() {
        if (articleList.size() == 0) {
            System.out.println("작성된 게시글이 없습니다.");
            return;
        }

        for (Article article : articleList) {
            System.out.printf("%d / %s / %s / %s \n", article.getId(), article.getTitle(), article.getBody(), article.getUserId());
        }
        System.out.print("수정할 글 번호: ");
        int modifyId = container.getSc().nextInt();

        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);
            if (article.getId() == modifyId) {

                System.out.print("제목: \n");
                String title = container.getSc().nextLine();
                article.setTitle(title);

                System.out.print("내용:");
                String body = container.getSc().nextLine();
                article.setBody(body);
            }
        }
        System.out.println("== 게시글이 수정 되었습니다 ==");
    }
}
