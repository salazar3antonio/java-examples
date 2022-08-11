package forkjoinpools;

import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public final class SummarizeClients {
    public static void main(String[] args) throws Exception {

        List<UdacisearchClient> clients = ClientStore.getClients();
        int numClients = clients.size();

        ForkJoinPool pool = new ForkJoinPool();

        Future<Integer> totalQuarterlySpend =
                pool.submit(() -> clients
                                .parallelStream()
                                .mapToInt(UdacisearchClient::getQuarterlyBudget)
                                .sum());

        Future<Double> averageBudget =
                pool.submit(() -> clients
                                .parallelStream()
                                .mapToDouble(UdacisearchClient::getQuarterlyBudget)
                                .average()
                                .orElse(0));

        Future<Long> nextExpiration =
                pool.submit(() -> clients
                                .parallelStream()
                                .min(Comparator.comparing(UdacisearchClient::getContractEnd))
                                .map(UdacisearchClient::getId)
                                .orElse(-1L));

        Future<Map<Year, Long>> contractsPerYear =
                pool.submit(() -> clients
                                .parallelStream()
                                .collect(
                                        Collectors.groupingByConcurrent(
                                                SummarizeClients::getContractYear, Collectors.counting())));

        pool.shutdown();

        System.out.println("Num clients: " + numClients);
        System.out.println("Total quarterly spend: " + totalQuarterlySpend.get());
        System.out.println("Average budget: " + averageBudget.get());
        System.out.println("ID of next expiring contract: " + nextExpiration.get());
        System.out.println("Contracts per year: " + contractsPerYear.get());
    }

    private static Year getContractYear(UdacisearchClient client) {
        LocalDate contractDate = LocalDate.ofInstant(client.getContractStart(), client.getTimeZones().get(0));
        return Year.of(contractDate.getYear());
    }
}
