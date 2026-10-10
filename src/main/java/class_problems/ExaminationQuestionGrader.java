import java.util.ArrayList;
import java.util.List;

/**
 * Problem 4: Examination Question Grader
 * Category C - Class Practice Problem 4
 *
 * Implements an exam evaluation system using polymorphism for MCQ, True/False, and keyword-based Essay grading.
 */
public class ExaminationQuestionGrader {

    public abstract static class Question {
        protected String type;
        protected String questionText;
        protected String correctAnswer;
        protected String studentAnswer;
        protected int points;

        public Question(String type, String questionText, String correctAnswer, String studentAnswer, int points) {
            this.type = type;
            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        public String getType() {
            return type;
        }

        public abstract double grade();
    }

    public static class MCQQuestion extends Question {
        public MCQQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
            super("MCQ", questionText, correctAnswer, studentAnswer, points);
        }

        @Override
        public double grade() {
            return correctAnswer.equals(studentAnswer) ? points : 0.0;
        }
    }

    public static class TFQuestion extends Question {
        public TFQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
            super("TF", questionText, correctAnswer, studentAnswer, points);
        }

        @Override
        public double grade() {
            return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0.0;
        }
    }

    public static class EssayQuestion extends Question {
        public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
            super("ESSAY", questionText, correctAnswer, studentAnswer, points);
        }

        @Override
        public double grade() {
            String[] keywords = correctAnswer.split(",");
            int matched = 0;
            String lowerStudentAnswer = studentAnswer.toLowerCase();

            for (String kw : keywords) {
                String cleanKw = kw.trim().toLowerCase();
                if (!cleanKw.isEmpty() && lowerStudentAnswer.contains(cleanKw)) {
                    matched++;
                }
            }

            if (matched >= 2) {
                return 0.75 * points;
            } else if (matched == 1) {
                return 0.50 * points;
            } else {
                return 0.0;
            }
        }
    }

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new MCQQuestion("What is the capital of France?", "Paris", "Paris", 10));
        questions.add(new TFQuestion("The Earth is flat?", "False", "True", 5));
        questions.add(new EssayQuestion("Name two primary OOP principles.", "Inheritance, Polymorphism, Encapsulation", "Polymorphism is one.", 20));
        questions.add(new EssayQuestion("Describe abstraction and composition.", "Abstraction, Composition", "I talked about abstraction.", 15));

        double totalScore = 0.0;
        for (Question q : questions) {
            double score = q.grade();
            totalScore += score;
            System.out.println(String.format("%s: %.2f", q.getType(), score));
        }
        System.out.println(String.format("Total Score: %.2f", totalScore));
    }
}