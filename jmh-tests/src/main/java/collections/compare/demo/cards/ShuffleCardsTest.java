package collections.compare.demo.cards;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(2)
public class ShuffleCardsTest
{
    @State(Scope.Thread)
    public static class Deck
    {
        public ApacheCommonsDeckOfCards apacheCommonsDeckOfCards = new ApacheCommonsDeckOfCards();
        public ApacheCommonsDeckOfCardsAsList apacheCommonsDeckOfCardsAsList = new ApacheCommonsDeckOfCardsAsList();
        public EclipseCollectionsDeckOfCards eclipseCollectionsDeckOfCards = new EclipseCollectionsDeckOfCards();
        public EclipseCollectionsDeckOfCardsAsImmutableList eclipseCollectionsDeckOfCardsAsImmutableList = new EclipseCollectionsDeckOfCardsAsImmutableList();
        public EclipseCollectionsDeckOfCardsAsReadableList eclipseCollectionsDeckOfCardsAsReadableList = new EclipseCollectionsDeckOfCardsAsReadableList();
        public GoogleGuavaDeckOfCards googleGuavaDeckOfCards = new GoogleGuavaDeckOfCards();
        public GoogleGuavaDeckOfCardsAsImmutableList googleGuavaDeckOfCardsAsImmutableList = new GoogleGuavaDeckOfCardsAsImmutableList();
        public JDK8DeckOfCards jdk8DeckOfCards = new JDK8DeckOfCards();
        public JDK8DeckOfCardsAsList jdk8DeckOfCardsAsList = new JDK8DeckOfCardsAsList();
        public VavrDeckOfCards javaslangDeckOfCards = new VavrDeckOfCards();
        public VavrDeckOfCardsAsImmutableList javaslangDeckOfCardsAsImmutableList = new VavrDeckOfCardsAsImmutableList();
    }

    @Benchmark
    public int shuffleApache(Deck deck)
    {
        return deck.apacheCommonsDeckOfCards.shuffle(new Random(123456789L))
                .size();
    }

    @Benchmark
    public int shuffleApacheUnmodifiable(Deck deck)
    {
        return deck.apacheCommonsDeckOfCardsAsList.shuffle(new Random(123456789L))
                .size();
    }

    @Benchmark
    public int shuffleEC(Deck deck)
    {
        return deck.eclipseCollectionsDeckOfCards.shuffle(new Random(123456789L))
                .size();
    }

    @Benchmark
    public int shuffleECImmutable(Deck deck)
    {
        return deck.eclipseCollectionsDeckOfCardsAsImmutableList.shuffle(new Random(123456789L))
                .size();
    }

    @Benchmark
    public int shuffleECReadable(Deck deck)
    {
        return deck.eclipseCollectionsDeckOfCardsAsReadableList.shuffle(new Random(123456789L))
                .size();
    }

    @Benchmark
    public int shuffleGuava(Deck deck)
    {
        return deck.googleGuavaDeckOfCards.shuffle(new Random(123456789L))
                .size();
    }

    @Benchmark
    public int shuffleGuavaImmutable(Deck deck)
    {
        return deck.googleGuavaDeckOfCardsAsImmutableList.shuffle(new Random(123456789L))
                .size();
    }

    @Benchmark
    public int shuffleJDK(Deck deck)
    {
        return deck.jdk8DeckOfCards.shuffle(new Random(123456789L))
                .size();
    }

    @Benchmark
    public int shuffleJDKUnmodifiable(Deck deck)
    {
        return deck.jdk8DeckOfCardsAsList.shuffle(new Random(123456789L))
                .size();
    }

    @Benchmark
    public boolean shuffleJavaslang(Deck deck)
    {
        return deck.javaslangDeckOfCards.shuffle(new Random(123456789L))
                .isEmpty();
    }

    @Benchmark
    public boolean shuffleJavaslangImmutable(Deck deck)
    {
        return deck.javaslangDeckOfCardsAsImmutableList.shuffle(new Random(123456789L))
                .isEmpty();
    }
}
