#!/usr/bin/env perl
open(HF,"<","v1.18.3_list.txt");
while(<HF>) {
	chomp $_;
	if($_ =~ m/.*\/(.*)/){
		my $cmd = "docker pull hellojukay/$1";
		printf "%s\n",$cmd;
		system($cmd);
	}
}
