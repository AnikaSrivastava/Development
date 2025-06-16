package streamsdemo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {

    public static void main(String[] args) {

        //sumOfStream();
        //filterAndPrint();
        //countEvenNumbers();
        //uppercaseConversion();
        //findMaximum();
        //flattenNestedLists();
        //SumOfSquares();
        //secondHighestNumber();
        //groupingByFirstLetter();
        //countingByFirstLetter();
        //TODO
        //partitionPrimes();
        //TODO
        //CustomCollector();
        //partitionOddEven();
        //parallelStreamIncorrect();
        //complexFiltering();
        //dataAggregation();
        //TODO
        /*13. Infinite Streams
        Write a stream pipeline that generates the Fibonacci
        sequence and prints the first 10 numbers.*/
        streamErr();

    }

    private static void streamErr() {
        List<String> list = Arrays.asList("Dhoni", "Kholi", "Rohit");
        String result = list.stream()
                .filter(s-> s.equalsIgnoreCase("Gill"))
                .findAny()
                .get();
        System.err.println(result);
    }



    /*
    Given a list of file paths (as List<String>), read all lines
    from these files and collect all unique words into a Set<String>.*/


    /*Given a List<demo.Transaction> with fields amount and type, compute:
        *The total sum of all transactions
        *The sum of transactions grouped by type
        *The average transaction amount*/
    private static void dataAggregation() {
        List<Transaction> transactions = new ArrayList<>();
        Transaction.addTransactions(transactions);

        //Sum of all transactions
        transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .reduce(Double::sum)
                .ifPresent(System.out::println);

        //The average transaction amount
        transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .average()
                .ifPresent(System.out::println);

        //sum of all transactions grouped by type
        transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getType, Collectors.summingDouble(Transaction::getAmount)))
                .forEach((k, v) -> System.out.println(k + ": " + v));

    }

    /*Given a list of demo.Person objects with name and age, use a stream to:
        * Filter those whose name starts with ‘A’
        * Are at least 18 years old
        * Then collect the names into a list.*/
    private static void complexFiltering() {
        List<Person> persons = new ArrayList<>();
        Person.addPersons(persons);

        persons.stream()
                .filter(person -> person.getName().startsWith("A"))
                .filter(person -> person.getAge() >= 18)
                .toList()
                .forEach(System.out::println);

    }

    private static void parallelStreamIncorrect() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Result using Parallel Stream");
        list.parallelStream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("Result using Stream");
        list.stream()
                .sorted()
                .forEach(System.out::println);

    }

    /* Implement a custom collector that joins a list of
    strings with a separator (e.g., “, ”).*/
    private static void CustomCollector() {

    }

    /*Given a list of integers, partition them into primes
     and non-primes using Collectors.partitioningBy()*/
    private static void partitionOddEven() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0))
        .forEach((key, value) -> System.out.println(key + " : " + value));
    }

    private static void isPrime(int number){

    }

    /*Given a list of words, count them by their first letter
         using Collectors.groupingBy().*/
    private static void countingByFirstLetter() {
        List<String> words = List.of("One" , "Two" , "Three" , "Four" , "Five");
        words.stream()
                .collect(Collectors.groupingBy(word -> word.substring(0,1), Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " : " + v));
    }

    /*Given a list of words, group them by their first letter
     using Collectors.groupingBy().*/
    private static void groupingByFirstLetter() {
        List<String> words = Arrays.asList("One", "Two", "Three", "Four", "Five");
        /*Map<String, List<String>> groupedList = */
        words.stream()
                .collect(Collectors.groupingBy(
                        word -> word.substring(0,1)))
                .forEach((key, value) -> System.out.println(key + " : " + value));

    }

    /*Write a stream pipeline to find the second highest
     unique number in a list of integer*/
    private static void secondHighestNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .skip(1)
                .forEach(System.out::println);

    }

    /*Given a list of integers, compute the sum of the
    squares using map() and reduce().*/
    private static void SumOfSquares() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.parallelStream()
                .map(n -> n*n)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }

    /*Given List<List<String>>, flatten it into a single
    List<String> using flatMap().*/
    private static void flattenNestedLists() {
        List<List<String>> listOfLists = new ArrayList<>();

        for(int i = 0; i<=10 ; i++){
            List<String> listOfStrings = Arrays.asList("A", "B", "C");
            listOfLists.add(listOfStrings);
        }
        for (List<String> listOfList : listOfLists) {
            System.out.println(listOfList);
        }

        listOfLists.stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

    }

    /*Given a list of integers, find the maximum value
    using a stream.*/
    private static void findMaximum() {
        List<Integer> numbers = Arrays.asList(1 , 2, 3, 4, 33, 22, 11, 32, 50, 21);
        numbers.stream()
                .max(Integer::compareTo)
                .ifPresent(System.out::println);
    }

    /*Given a list of strings, use map() to convert them
    all to uppercase and collect them into a new list*/
    private static void uppercaseConversion() {
        List<String> lowerCaseStrings = Arrays.asList("Hello", "World");
        lowerCaseStrings.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    /*Given a list of integers, use a stream
    to count how many of them are even.*/
    private static void countEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.stream()
                .filter(n -> n%2 == 0)
                .forEach(System.out::println);

    }

    /*Write a stream pipeline that prints all names in
    a list that start with the letter 'A' (case-insensitive).*/
    private static void filterAndPrint() {
        List<String> names = Arrays.asList("Anika", "Amit" , "Arti" , "Anshu" , "Pooja", "Nishu");
        names.stream()
                .filter(list -> list.startsWith("A"))
                .forEach(System.out::println);
        names.parallelStream()
                .filter(name -> name.startsWith("Alice"))
                .forEach(System.out::println);

    }

    private static void sumOfStream() {
        int sum = Stream.of(1, 2, 3, 4, 5).reduce(0, Integer::sum);
        System.out.println(sum);
    }




}
