use strict;
use warnings;

use Time::HiRes;


sub isValid {
    my ($n) = @_;

    my $d = undef;
    my $dv = 0;
    my $c = 0;

    while ($n > 0) {
        if ($dv && ($d == ($n % 10))) {
            if ($c) {
                return 0;
            }
            $c = 1;
        } else {
            $dv = 1;
            $c = 0;
        }

        use integer;
        $d = $n % 10;
        $n = $n / 10;
    }

    return 1;
}

sub generateValidNumberList {
    my @l = [];

    for (my $i = 10; $i <= 99; $i++) {
        if (isValid($i)) {
            push(@l, $i)
        }
    }

    for (my $i = 1000; $i <= 9999; $i++) {
        if (isValid($i)) {
            push(@l, $i)
        }
    }

    for (my $i = 100000; $i <= 999999; $i++) {
        if (isValid($i)) {
            push(@l, $i)
        }
    }

    return @l;
}

my $t0 = [Time::HiRes::gettimeofday()];
generateValidNumberList();
my $dt = (Time::HiRes::tv_interval($t0)) * 1000;
print("$dt\n");
