package datastructure.graph.min_path;

/**
 * Created by Edwin Xu on 9/3/2020 4:36 PM
 */
public class Floyd {
}

/*
*
Floyd的模板：
#include<iostream>
#include<cstdio>
#include<cstring>
#include<algorithm>
using namespace std;
const int MAXN = 0x3f3f3f3f;
const int p = 1005;
int dist[p][p];
int path[p][p];
int mp[p][p];
int n,m;
int Floyd()
{
    int i,j,k;
    for(i = 0;i < n;++i)
    {
        for(j = 0;j < n;++j)
        {
            dist[i][i]=0;
            mp[i][i]=0;
        }
    }
    int ans = MAXN;
    for(k = 0;k < n;++k){
    for(i = 0;i < n;++i)
    {
        for(j = 0;j < n;++j)
        {
            if(dist[i][k] + dist[k][j] < dist[i][j])
            {
                dist[i][j] = dist[i][k] + dist[k][j];
                path[i][j] = k;
            }
        }
    }
    }
    return ans;
}
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int i,j;
        memset(path,-1,sizeof(path));
        memset(dist,MAXN,sizeof(dist));
        memset(mp,MAXN,sizeof(mp));
        scanf("%d %d",&n,&m);
        for(int i = 0;i < m;++i)
        {
            int x,y,d;
            scanf("%d %d %d",&x,&y,&d);
            dist[x][y]=d;
            dist[y][x]=d;
            mp[x][y]=d;
            mp[y][x]=d;
        }
        printf("%d\n",Floyd());
        for(i = 0;i < n;++i)
        {
            for(j = 0;j < n;++j)
            {
                printf("%d ",dist[i][j]);
            }
            cout<<endl;
        }
        for(i = 0;i < n;++i)
        {
            for(j = 0;j < n;++j)
            {
                printf("%d ",path[i][j]);
            }
            cout<<endl;
        }
    }
    return 0;
}



*/