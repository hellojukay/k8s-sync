#!/usr/bin/env perl
open(HF,"<","v1.18.5_list.txt");
while(<HF>) {
	chomp $_;
    my $image = $_;
	if($_ =~ m/.*\/(.*)/){
		my $cmd = "docker pull hellojukay/$1";
		printf "%s\n",$cmd;
		system($cmd);
       	system("docker tag hellojukay/$1 $image");
        system("docker rmi hellojukay/$1");
	}
}
